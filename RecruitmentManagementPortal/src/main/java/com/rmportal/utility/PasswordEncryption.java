package com.rmportal.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.rmportal.requestModel.LoginRequestModel;

@Component
public class PasswordEncryption {
	
	LoginRequestModel loginRequest;
	
	@Autowired
	PasswordEncoder bCryptPassword; 
	
	//String hashEncoder1 = bCryptPassword.encode(loginRequest.getPassword());

}
