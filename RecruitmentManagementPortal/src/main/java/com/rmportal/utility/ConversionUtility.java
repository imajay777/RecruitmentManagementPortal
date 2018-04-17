package com.rmportal.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rmportal.model.User;
import com.rmportal.requestModel.RegisterRequestModel;
import com.rmportal.responseModel.ResponseModel;
import com.rmportal.responseModel.UserResponseDTO;

/**
 * @author tejas
 *
 */
@Component
public class ConversionUtility {

	@Autowired
	PasswordEncryption passwordEncryption;

	public User convertRequestToUser(RegisterRequestModel registerRequestModel) {

		User user = new User();
		user.setEmail(registerRequestModel.getEmail());
		user.setUsername(registerRequestModel.getUsername());
		user.setFirstname(registerRequestModel.getFirstname());
		user.setLastname(registerRequestModel.getLastname());
		System.out.println(registerRequestModel.getPassword());
		user.setPassword(passwordEncryption.hashEncoder(registerRequestModel.getPassword()));

		return user;
	}

	public UserResponseDTO convertUserToresponse(User user) {

		UserResponseDTO userResponseDTO = new UserResponseDTO();

		userResponseDTO.setEmail(user.getEmail());
		userResponseDTO.setFirstname(user.getFirstname());
		userResponseDTO.setLastname(user.getLastname());

		return userResponseDTO;
		// TODO Auto-generated method stub

	}

	public ResponseModel convertUserToResponse(User userFromTable) {
		ResponseModel responseModel = new ResponseModel();
		responseModel.setEmail(userFromTable.getEmail());
		responseModel.setFirst_name(userFromTable.getFirstname());
		responseModel.setLast_name(userFromTable.getLastname());
		responseModel.setMobile(userFromTable.getId());
		return responseModel;

	}

	public String setStatusToUser() {

		User user = new User();
		user.setActive(true);
		return "UserActivated";
	}

}
