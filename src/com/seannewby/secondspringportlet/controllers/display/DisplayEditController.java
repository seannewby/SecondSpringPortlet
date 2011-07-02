package com.seannewby.secondspringportlet.controllers.display;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("EDIT")
public class DisplayEditController {
	
	@RequestMapping
	public String showEdit() throws Exception { 
		
		System.out.println("In Display Edit Controller.");
		
		return "displayEdit";
	}

}