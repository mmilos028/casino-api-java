package api.casino;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication(
		/*exclude= {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
		org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class,		
		},*/
		scanBasePackages = {
		"api.casino",
		"api.casino.config",		
		"api.casino.entity",
		"api.casino.model",
		"api.casino.repository",
		"api.casino.service",
		"api.casino.controller",
		"api.casino.api.server",
		"api.casino.broker.stream",
		}
)
@ComponentScan({ 
	"api.casino.config", 
	"api.casino.model", 
	"api.casino.service", 
	"api.casino.controller", 
	"api.casino.api.server", 
	"api.casino.command.service", 
	"api.casino.command.action", 
	"api.casino.broker.producer",
	"api.casino.broker.consumer",
	"api.casino.broker.stream",
	"api.casino.repository",	
	
	})
@EntityScan("api.casino.entity")
@EnableJpaRepositories(basePackages={"api.casino.repository"})
@EnableKafka
public class CasinoApiJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasinoApiJavaApplication.class, args);
	}
	
	
	@Bean
	public FilterRegistrationBean<CorsFilter> simpleCorsFilter() {
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    CorsConfiguration config = new CorsConfiguration();
	    config.setAllowCredentials(true);
	    config.setAllowedOrigins(Arrays.asList("http://localhost:8080"));
	    config.setAllowedMethods(Collections.singletonList("*"));
	    config.setAllowedHeaders(Collections.singletonList("*"));
	    source.registerCorsConfiguration("/**", config);
	    FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
	    bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
	    return bean;
	}
	
}
