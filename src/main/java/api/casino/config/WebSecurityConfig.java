package api.casino.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity(debug=false)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	/*
	@Bean
	PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
		//return new BCryptPasswordEncoder();
		//return NoOpPasswordEncoder.getInstance();
	}
	*/
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
		
		web
			.ignoring()
			.antMatchers("/h2-console/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		
		http.authorizeRequests()
        .antMatchers("/h2-console/**").permitAll()
        .anyRequest().authenticated();
        ;
        
        http.headers().frameOptions().sameOrigin();
		
		//http
		//.cors().and()
		//.csrf().disable()
		//.headers().frameOptions().sameOrigin()
		/*.authorizeHttpRequests( authorize -> {
			authorize.antMatchers("/", "/users", "/api/jackpot", "/api/promotion").permitAll()
			;
		})*/
		
		/*.authorizeRequests()
		.antMatchers("/users").access("hasRole('USER')")
		*/
		
		//.authorizeRequests()
		//.anyRequest().authenticated()
		//.and()
		//.and()
		//.formLogin().and().httpBasic()
		
		//.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication()
		.withUser("admin")
		.password(new BCryptPasswordEncoder().encode("admin"))
		.roles("ADMIN")
		.and()
		.withUser("user")
		.password(new BCryptPasswordEncoder().encode("user"))
		.roles("USER")
		.and()
		.withUser("milos")
		.password(new BCryptPasswordEncoder().encode("milos"))
		.roles("CUSTOMER")
		;
	}

}
