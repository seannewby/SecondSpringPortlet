package com.seannewby.secondspringportlet.common.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.seannewby.secondspringportlet.common.beans.User;

@Component("userContactInfoValidator")
public class UserContactInfoValidator implements Validator {

	@SuppressWarnings("unchecked")
	public boolean supports(Class clazz) {
		
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {
		
		User user = (User)obj;

		validateEmail(user, errors);

	}

	
	public void validateEmail(User user, Errors errors){
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.email.required", "User email is required.");
	}
}
