package com.admin_dashboard.security.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.admin_dashboard.security.model.User;

@Component
public class UserValidator implements Validator {

	// Specify that a instance of the User Domain Model can be validated with this custom validator
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	// Creating our custom validation, we can add errors via .rejectValue(String, String)
	@Override
	public void validate(Object target, Errors errors) {
		User user=(User) target;
		
		if(!user.getPassword().equals(user.getConfirm())) {
			errors.rejectValue("confirm","Match");
		}
		
	}

	
	
}
