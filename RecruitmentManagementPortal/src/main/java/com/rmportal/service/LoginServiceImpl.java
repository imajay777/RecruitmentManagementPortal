package com.rmportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmportal.constants.HttpStatusConstants;
import com.rmportal.model.User;
import com.rmportal.repository.UserRepository;
import com.rmportal.requestModel.LoginRequestModel;
import com.rmportal.responseModel.ResponseModel;
import com.rmportal.utility.ConversionUtility;
import com.rmportal.utility.CustomException;

/**
 * @author saurabh
 *
 */

@Service
public class LoginServiceImpl implements LoginServices {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ConversionUtility conversionUtility;

	@Override
	public ResponseModel validateUser(LoginRequestModel loginRequestModel) throws CustomException {
		
		User userFromTable = userRepository.findByEmail(loginRequestModel.getEmail(), loginRequestModel.getPassword());

		if (userFromTable == null) {
			throw new CustomException(HttpStatusConstants.NO_CONTENT.id, HttpStatusConstants.NO_CONTENT.getStatus());
		} else {
			return conversionUtility.convertUserToResponse(userFromTable);
		}

	}

}
