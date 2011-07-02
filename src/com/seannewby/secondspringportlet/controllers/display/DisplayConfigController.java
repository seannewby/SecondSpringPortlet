package com.seannewby.secondspringportlet.controllers.display;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("CONFIG")
public class DisplayConfigController {
	
	@RequestMapping
	public String showConfig() throws Exception { 
		
		System.out.println("In Display Config Controller.");
		
		return "displayConfig";
	}

}