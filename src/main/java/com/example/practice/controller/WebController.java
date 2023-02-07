package com.example.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

	@GetMapping("/")
	public String index() {
		return "home";
	}

	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}


	@GetMapping("/signin")
	public String signin() {return "signin";}
}
