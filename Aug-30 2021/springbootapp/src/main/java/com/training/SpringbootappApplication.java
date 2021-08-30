package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.controller"})
public class SpringbootappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootappApplication.class, args);
	}

}
