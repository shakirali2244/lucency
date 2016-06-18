package lucency;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
    	RestHelper rh = new RestHelper();
        System.out.println("test"+rh.get("https://api.instagram.com/v1/users/self/followed-by?access_token=2966688347.3b60e99.1744404d6bc544a7a13138789fe8610d"));
    }
}