package com.training.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{

	//Authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication()
					.passwordEncoder(passwordEncoder())
					.withUser("abc").password(passwordEncoder().encode("abc")).roles("USER")
					.and()
					.withUser("xyz").password(passwordEncoder().encode("xyz")).roles("USER");
	}
	
	
	//Authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.authorizeRequests()
			.antMatchers("/", "/home").permitAll()
			//.anyRequest().authenticated()
			.anyRequest().permitAll()
			.and()
			.formLogin().loginPage("/login").permitAll()
			.and()
			.logout().permitAll();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
}



