package lucency;


import java.sql.Timestamp;

import org.apache.commons.dbcp2.BasicDataSource;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class ScheduledTasks {
    private JdbcTemplate jdbcTemplate;
    
    
    public void setDataSource(BasicDataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	@Scheduled(fixedRate = 5000)
    public void getFollowers() {
    	RestHelper rh = new RestHelper();
    	String data = rh.get("https://api.instagram.com/v1/users/self/followed-by?access_token=2966688347.3b60e99.1744404d6bc544a7a13138789fe8610d");
        System.out.println(data);
        JSONObject obj = new JSONObject(data);
        JSONArray arr = obj.getJSONArray("data");
        java.util.Date date= new java.util.Date();
      	Timestamp ts = new Timestamp(date.getTime());
        for (int i = 0; i < arr.length(); i++){
        	JSONObject object = arr.getJSONObject(i); 
        	this.jdbcTemplate.update(
                    "update ig_followers set user_name=?,full_name=?,dp_url=?,follower_till=? where"
                    + " user_id = ? AND parent_id = ?;"
                    + " insert into ig_followers (user_id,user_name,full_name,dp_url,followed_on,follower_till,parent_id)"
                    + " select ?,?,?,?,?,?,? "
                    + " where not exists (select 1 from ig_followers where user_id = ? AND parent_id = ?);",
                    object.getString("username"),object.getString("full_name"),object.getString("profile_picture"),ts,
                    object.getInt("id"),1,
                    object.getInt("id"),object.getString("username"),object.getString("full_name"),
                    object.getString("profile_picture"),ts,ts,1,
                    object.getInt("id"),1);
        }
        
    }
}