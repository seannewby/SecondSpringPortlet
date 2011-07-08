package com.seannewby.secondspringportlet.controllers.display;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seannewby.secondspringportlet.common.service.LocationService;

@Controller
@RequestMapping("VIEW")
public class DisplayIndexController{
	
	
	private LocationService locationService;
	
	//Prepares a list of locations for view to display.
	@RequestMapping
	public String displayLocations(Model model) throws Exception { 

		model.addAttribute("locations", locationService.getLocations());
	
		return "displayIndex";
	}

	/*
	 * Setters for Spring Injection
	 * 
	 */
	@Autowired
	@Qualifier("locationService")
	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}

}
