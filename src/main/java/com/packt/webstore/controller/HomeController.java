package com.packt.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

	@RequestMapping("/")
	public String welcome(Model model) {
		
		model.addAttribute("greeting", "Welcome to Web Store!");				//"greeting" is linked to the 'welcome.jsp' page, <h1> tags
		model.addAttribute("tagline", "The one and only amazing web store");	//"tagline" is linked to the 'welcome.jsp' page, <p> tags
		
		return "welcome";
		
	}
	
}
