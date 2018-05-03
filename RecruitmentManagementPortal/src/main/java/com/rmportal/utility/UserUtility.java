package com.rmportal.utility;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.rmportal.constants.HttpStatusConstants;
import com.rmportal.requestModel.RegisterRequestModel;


public class UserUtility {
	
	private UserUtility (){
		//this class can not be instantiated
	}

	public static boolean isInvalidValue(String value) {
		return Objects.isNull(value) || value.isEmpty();
	}
	
	public static boolean isInvalidMobile(long mobile) {
		return Objects.isNull(Long.valueOf(mobile));
	}
	

	

}
