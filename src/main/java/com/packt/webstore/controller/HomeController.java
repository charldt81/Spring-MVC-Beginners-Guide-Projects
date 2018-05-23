package com.packt.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


// here we added the request mapping on the class level
@RequestMapping("/")
@Controller
public class HomeController {

	
	// this is a default request mapping as it has no relative path
	@RequestMapping
	public String welcome(Model model) {
		
		model.addAttribute("greeting", "Welcome to Web Store!");				// "greeting" is linked to the 'welcome.jsp' page, <h1> tags
		model.addAttribute("tagline", "The one and only amazing web store");	// "tagline" is linked to the 'welcome.jsp' page, <p> tags
		
		return "welcome";
		
	}
	
}

