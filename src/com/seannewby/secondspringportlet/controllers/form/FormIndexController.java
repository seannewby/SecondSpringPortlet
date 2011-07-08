package com.seannewby.secondspringportlet.controllers.form;

import java.util.List;

import javax.portlet.ActionResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ActionMapping;


import com.seannewby.secondspringportlet.common.beans.Location;
import com.seannewby.secondspringportlet.common.service.AddressUtilsService;
import com.seannewby.secondspringportlet.common.service.LocationService;


@Controller
@RequestMapping("VIEW")
public class FormIndexController {
	
	private AddressUtilsService addressUtils;
	private LocationService locationService;
	private Validator locationValidator;
	
	@RequestMapping
	public String showForm(Model model) throws Exception{
		if (!model.containsAttribute("location")) {
			Location location = new Location();
			model.addAttribute("location", location);			
		}
		
		List<String> states = addressUtils.getStates();
		List<Location> locations = locationService.getLocations();
		model.addAttribute("states", states);
		model.addAttribute("locations", locations);
		
		return "formIndex";
	}
	
	@RequestMapping(params = "action=editLocation")
	public String showSuccess(@RequestParam("locationId") int locationId, Model model ) throws Exception{
		
		if (!model.containsAttribute("location")) {
			Location location = locationService.getLocation(locationId);
			model.addAttribute("location", location);			
		}
	
		return showForm(model);
	}
	
	@RequestMapping(params = "action=successAddEdit")
	public String showSuccess() throws Exception{
		
		return "formSuccess";
	}
	
	
	@ActionMapping(params = "action=addLocation") 
	public void addLocation(ActionResponse response, @ModelAttribute("location")Location location, BindingResult result) throws Exception {
		
		locationValidator.validate(location, result);
		if (result.hasErrors()) {
			response.setRenderParameter("action", "addLocation");
		}
		else{
			locationService.addLocation(location);		
			response.setRenderParameter("action", "successAddEdit");
		}
	}

	@ActionMapping(params = "action=editLocation") 
	public void editLocation(ActionResponse response, @ModelAttribute("location")Location location,  BindingResult result) throws Exception {
		
		locationValidator.validate(location, result);
		
		if (result.hasErrors()) {
			response.setRenderParameter("action", "editLocation");
			response.setRenderParameter("locationId", Integer.toString(location.getId()));
		}
		else{
			locationService.updateLocation(location);
			
			response.setRenderParameter("action", "successAddEdit");			
		}
		

		
	}

	/*
	 * Setters for Spring Injection
	 * 
	 */
	@Autowired
	@Qualifier("addressUtilsService")
	public void setAddressUtils(AddressUtilsService addressUtils) {
		this.addressUtils = addressUtils;
	}

	@Autowired
	@Qualifier("locationService")
	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}

	@Autowired
	@Qualifier("locationValidator")
	public void setLocationValidator(Validator locationValidator) {
		this.locationValidator = locationValidator; 
	}


}
