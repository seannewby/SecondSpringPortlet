package com.seannewby.secondspringportlet.common.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.seannewby.secondspringportlet.common.beans.User;

@Component("userBasicInfoValidator")
public class UserBasicInfoValidator implements Validator {

	@SuppressWarnings("unchecked")
	public boolean supports(Class clazz) {
		
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {
		
		User user = (User)obj;
		validateUsername(user, errors);
		validateFirstname(user, errors);
		validateLastname(user, errors);
		validatePassword(user, errors);
		validateBirthdate(user, errors);

	}

	public void validateUsername(User user, Errors errors){
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.username.required", "User name is required.");
	}
	
	public void validateFirstname(User user, Errors errors){
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "error.firstname.required", "User first name is required.");
	}
	
	public void validateLastname(User user, Errors errors){
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "error.lastname.required", "User last name is required.");
	}
	
	public void validatePassword(User user, Errors errors){
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.password.required", "User password is required.");
	}

	public void validateBirthdate(User user, Errors errors){
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthdate", "error.birthdate.required", "User birthdate is required.");
	}
	

}
