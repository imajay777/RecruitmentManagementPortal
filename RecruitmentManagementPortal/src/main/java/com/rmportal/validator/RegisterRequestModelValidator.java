package com.rmportal.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.rmportal.requestModel.RegisterRequestModel;

@Component

public class RegisterRequestModelValidator implements Validator {


	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(RegisterRequestModel.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub

		RegisterRequestModel regs=(RegisterRequestModel) (target);
		
		
	}

}
