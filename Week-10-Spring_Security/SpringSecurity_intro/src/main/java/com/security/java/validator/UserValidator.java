package com.security.java.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.security.java.models.User;

@Component
public class UserValidator {

	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	
	//  Specifies that a instance of the User Domain Model can be validated with this custom validator
	public void validate(Object object, Errors errors) {
        User user = (User) object;
        
        if(!user.getConfirm().equals(user.getPassword())){
        	errors.rejectValue("confirm", "Match");
        }
        if(user.getUsername().equals("moneem")) {
        	errors.rejectValue("username","notAvailable");
        }
	}
}
