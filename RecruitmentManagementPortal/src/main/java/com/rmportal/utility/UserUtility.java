package com.rmportal.utility;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.rmportal.constants.HttpStatusConstants;
import com.rmportal.requestModel.RegisterRequestModel;

public class UserUtility {

	private UserUtility() {
		// this class can not be instantiated
	}

	public static boolean isInvalidValue(String value) {
		return (Objects.isNull(value) || value.isEmpty());
	}

	public static boolean isValidMobile(String mobile) {
		return mobile.matches("^[0-9]{10}$");
	}

	

	public static boolean isValidEmail(String email) {
		Pattern emailPattern = Pattern.compile("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$",
				Pattern.CASE_INSENSITIVE);

		Matcher m = emailPattern.matcher(email);

		return m.matches();

	}

}
