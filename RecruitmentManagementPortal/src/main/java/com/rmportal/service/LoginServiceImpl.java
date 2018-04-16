package com.rmportal.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmportal.constants.Constants;
import com.rmportal.model.User;
import com.rmportal.repository.UserRepository;
import com.rmportal.requestModel.LoginRequestModel;
import com.rmportal.responseModel.LoginResponseModel;

/**
 * @author saurabh
 *
 */

@Service
public class LoginServiceImpl implements LoginServices {

	@Autowired
	UserRepository userRepository;

	@Override
	public LoginResponseModel validateUser(LoginRequestModel loginRequestModel) {
		LoginResponseModel apiResponse = new LoginResponseModel();
		User userFromTable = userRepository.findByEmail(loginRequestModel.getEmail(), loginRequestModel.getPassword());
		if (Objects.nonNull(userFromTable)) {
			if (userFromTable.isActive() == true) {
				apiResponse.setMessage(Constants.OK.getStatus());
				apiResponse.setResponse(userFromTable.getFirstname());
				apiResponse.setStatus(Constants.OK.getId());
			}
			else{
				apiResponse.setMessage("Your account is deactivated. Please Activate Your account");
				apiResponse.setResponse(userFromTable.getFirstname());
				apiResponse.setStatus(Constants.RESET_CONTENT.getId());
			}
		} else {
			apiResponse.setMessage(Constants.NON_AUTHORITATIVE_INFORMATION.getStatus());
			apiResponse.setResponse("Username or Password is Invalid!!!");
			apiResponse.setStatus(Constants.NON_AUTHORITATIVE_INFORMATION.getId());
		}

		return apiResponse;
	}

}
