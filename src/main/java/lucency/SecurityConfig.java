package lucency;




import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	
	@Bean(name = "dataSource")
	 public DriverManagerDataSource dataSource() {
	     DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	     driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
	     driverManagerDataSource.setUrl("jdbc:postgresql://127.0.0.1:5432/lucencyDB");
	     driverManagerDataSource.setUsername("postgres");
	     return driverManagerDataSource;
	 }
	 
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/","/resources/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
            .loginPage("/login")
            .permitAll()
            .and()
        .logout()
            .permitAll();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	//System.out.println("adasdasd"+dataSource.getClass());
        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username,password,true from users where username = ?").authoritiesByUsernameQuery("select username,'ADMIN' from users where username = ?");
        
    }
}
