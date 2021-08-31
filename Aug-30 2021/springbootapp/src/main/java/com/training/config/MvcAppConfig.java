package com.training.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcAppConfig implements WebMvcConfigurer {

	// MVC Fetaures
	// CORS
	// Interceptors
	// View Controllers
	// Resource Handlers
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/logoff").setViewName("logout");
	}
}
