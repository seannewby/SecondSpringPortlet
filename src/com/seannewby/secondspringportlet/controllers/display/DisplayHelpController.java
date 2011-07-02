package com.seannewby.secondspringportlet.controllers.display;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("HELP")
public class DisplayHelpController {
	
	@RequestMapping
	public String showHelp() throws Exception { 
			
		System.out.println("In Display Help Controller.");
		
		return "displayHelp";
	}

}