package api.casino.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Profile;

@EnableResourceServer
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	
	/*@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) {
		try {
			return http.build();
			
			return http.oauth2ResourceServer(
					j -> j.jwt().jwkSetUri("http://localhost:8080/oauth2/jwks")
					)
			//.authorizeRequests()
			//.anyRequest().authenticated()
			//.and().build()
			.build()
			;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	*/
	
    @Override
    public void configure(HttpSecurity http) throws Exception {
    	    	    	
    	//dozvoljeno sve
    	http   	
    	.csrf().disable()
    	.authorizeRequests()
    	.antMatchers("/api/**")
    	.permitAll()
    	;
    	
    	//mora da koristi /oauth/token i test/test sa read da dobije token pa na bearer token
        http
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