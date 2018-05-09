package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String homePage() {
		return "index";
	}

	@RequestMapping("/privacy")
	public String privacy() {
		return "privacy";
	}
	
	@RequestMapping("/termsAndConditions")
	public String termsAndConditions() {
		return "privacy";
	}
	
	@RequestMapping("/registrationform")
	public String registrationform() {
		return "registrationform";
	}

	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		if (error != null) {
			model.addAttribute("error", "Invalid username and password");
		}
		if (logout != null) {
			model.addAttribute("msg", "You have been logged out successfully");
		}
		return "login";
	}
}
