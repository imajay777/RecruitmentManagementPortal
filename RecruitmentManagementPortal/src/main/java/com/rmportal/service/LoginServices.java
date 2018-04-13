package com.rmportal.service;

import org.springframework.stereotype.Repository;

import com.rmportal.model.LoginModel;
import com.rmportal.requestModel.LoginRequestModel;
import com.rmportal.responseModel.LoginResponseModel;

/**
 * @author saurabh
 *
 */
@Repository
public interface LoginServices {

	public LoginResponseModel validateUser(LoginRequestModel loginRequestModel);

}
