package com.seannewby.secondspringportlet.common.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.seannewby.secondspringportlet.common.beans.User;

@Component("userBillingInfoValidator")
public class UserBillingInfoValidator implements Validator {

	@SuppressWarnings("unchecked")
	public boolean supports(Class clazz) {
		
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {
		
		User user = (User)obj;
		validateCreditCardNumber(user, errors);

	}

	public void validateCreditCardNumber(User user, Errors errors){
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "creditCardNum", "error.creditCardNum.required", "User credit card number is required.");
	}
	

}
