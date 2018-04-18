package com.rmportal.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.rmportal.requestModel.LoginRequestModel;
import com.rmportal.requestModel.RegisterRequestModel;

/**
 * @author saurabh
 *
 */
@Component
public class PasswordEncryption {

	/*@Autowired
	PasswordEncoder bCryptPassword;

	public String hashEncoder(RegisterRequestModel registerRequestModel) {
		String hashEncoder = bCryptPassword.encode(registerRequestModel.getPassword());
		return hashEncoder;
	}
	
	*/
}
