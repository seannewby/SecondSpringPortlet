package com.seannewby.secondspringportlet.controllers.display;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.seannewby.secondspringportlet.common.service.LocationService;

@Controller
@RequestMapping("VIEW")
public class DisplayDetailController {
	
	private LocationService locationService;
	
	//Prepares specified location for display in view.
	@RequestMapping(params = "action=detail")
	public String showDetail(@RequestParam("locationId")int locationId, Model model) throws Exception { 
				
		model.addAttribute("location", locationService.getLocation(locationId));
		
		System.out.println("In Display Controller.");
		
		return "displayDetail";
	}

	/*
	 * Setters for Spring Injection
	 * 
	 */
	@Autowired
	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}

}
