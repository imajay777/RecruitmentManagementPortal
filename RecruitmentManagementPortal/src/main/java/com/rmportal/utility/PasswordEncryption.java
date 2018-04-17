package com.rmportal.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.rmportal.requestModel.LoginRequestModel;

/**
 * @author saurabh
 *
 */
@Component
public class PasswordEncryption {

	@Autowired
	PasswordEncoder bCryptPassword;

	public String hashEncoder(LoginRequestModel loginRequestModel) {
		String hashEncoder = bCryptPassword.encode(loginRequestModel.getPassword());
		return hashEncoder;
	}
	
	
}
