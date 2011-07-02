package com.seannewby.secondspringportlet.common.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.seannewby.secondspringportlet.common.beans.Location;

public class LocationValidator implements Validator {

	@SuppressWarnings("unchecked")
	public boolean supports(Class clazz) {
		
		return Location.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {
		
		Location location = (Location)obj;
		validateName(location, errors);
		validateDesc(location, errors);
		validateRegion(location, errors);
		validateManager(location, errors);

	}

	public void validateName(Location location, Errors errors){
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.name.required", "Location name is required.");
	}
	
	public void validateDesc(Location location, Errors errors){
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "desc", "error.desc.required", "Location description is required.");
	}

	public void validateRegion(Location location, Errors errors){
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "region", "error.region.required", "Location region is required.");
	}
	
	public void validateManager(Location location, Errors errors){
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "manager", "error.manager.required", "Location manager is required.");
	}
}
