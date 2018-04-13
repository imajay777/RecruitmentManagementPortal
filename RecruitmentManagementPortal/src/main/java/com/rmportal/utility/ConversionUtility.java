package com.rmportal.utility;

import org.springframework.stereotype.Component;

import com.rmportal.model.Role;
import com.rmportal.model.User;
import com.rmportal.requestModel.RegisterRequestModel;

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
		Role role = new Role();
		user.setRoles(role);

		return user;
	}
}
