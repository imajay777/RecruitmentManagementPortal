package com.rmportal.utility;

import org.springframework.stereotype.Component;

import com.rmportal.model.Role;
import com.rmportal.model.User;
import com.rmportal.requestModel.RegisterRequestModel;
import com.rmportal.responseModel.UserResponseDTO;

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

	public UserResponseDTO convertUserToresponse(User user) {
		

		UserResponseDTO userResponseDTO = new UserResponseDTO();
		
		userResponseDTO.setEmail(user.getEmail());
		userResponseDTO.setFirstname(user.getFirstname());
		userResponseDTO.setLastname(user.getLastname());
		
		return userResponseDTO;
		// TODO Auto-generated method stub
		
	}
}
