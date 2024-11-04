package com.patasSolidarias.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
	
	 @GetMapping("/")
	 public String home() {
		 return "redirect:/index.html";
	    }

}
