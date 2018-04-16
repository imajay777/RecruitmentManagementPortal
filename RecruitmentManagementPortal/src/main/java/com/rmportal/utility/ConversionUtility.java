package com.rmportal.utility;

import org.springframework.stereotype.Component;

import com.rmportal.constants.HttpStatusConstants;
import com.rmportal.model.Role;
import com.rmportal.model.User;
import com.rmportal.requestModel.RegisterRequestModel;
import com.rmportal.responseModel.ResponseModel;

/**
 * @author tejas
 *
 */
@Component
public class ConversionUtility {

	public User convertRequestToUser(RegisterRequestModel registerRequestModel) {

		User user = new User();
		user.setEmail(registerRequestModel.getEmail());
		user.setUsername(registerRequestModel.getUsername());
		user.setFirstname(registerRequestModel.getFirstname());
		user.setLastname(registerRequestModel.getLastname());
		user.setPassword(registerRequestModel.getPassword());

		return user;
	}

	public ResponseModel convertUserToResponse(User userFromTable) {
		ResponseModel responseModel = new ResponseModel();
		responseModel.setEmail(userFromTable.getEmail());
		responseModel.setFirst_name(userFromTable.getFirstname());
		responseModel.setLast_name(userFromTable.getLastname());
		responseModel.setMobile(userFromTable.getId());
		return responseModel;
	
	}
	
	 
}
