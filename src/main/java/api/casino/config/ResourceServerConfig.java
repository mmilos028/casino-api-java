package api.casino.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.context.annotation.Profile;

@EnableResourceServer
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
    	
        http
        	//.httpBasic()
        	//.disable()
            .antMatcher("/users")
            .authorizeRequests()
            .anyRequest()
            .authenticated()
            
            //.access("#oauth2.hasScope('read')");
            ;
    }
    
    /*@Configuration
	protected static class AuthenticationManagerConfiguration extends GlobalAuthenticationConfigurerAdapter {

		@Override
		public void init(AuthenticationManagerBuilder auth) throws Exception {
			
			//auth.jdbcAuthentication().
			
			auth
			.inMemoryAuthentication()			
			.withUser("test2")
			.password("test2")
			.roles("USER")
			.authorities("USER")
			
			;
		}

	}*/
    
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}