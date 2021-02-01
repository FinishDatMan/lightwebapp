package com.springproject.lightwebapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.springproject.lightwebapp.models.State;

@Controller
public class ApplicationController {

	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/logout") 
	public String logout() {
		return "logout";
	}
}
