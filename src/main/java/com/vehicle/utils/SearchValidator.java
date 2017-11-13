package com.vehicle.utils;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.vehicle.dto.Login;
import com.vehicle.dto.LoginDTO;

@Component
public class SearchValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return LoginDTO.class.equals(arg0) || Login.class.equals(arg0) ;
	}

	@Override
	public void validate(Object obj, Errors err) {
	      ValidationUtils.rejectIfEmptyOrWhitespace(err, "search", "Empty.searchForm.search");
		
	}

}
