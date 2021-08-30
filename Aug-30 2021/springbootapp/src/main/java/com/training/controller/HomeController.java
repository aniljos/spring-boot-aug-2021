package com.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	// app/home
	@GetMapping("/home")
	public String getHome() {
		
		System.out.println("HomeController.getHome()");
		return "home";
	}
}
