package com.rmportal.service;

import com.rmportal.model.User;
import com.rmportal.requestModel.RegisterRequestModel;
import com.rmportal.responseModel.RegisterResponseModel;

/**
 * @author tejas
 *
 */

public interface UserServices {

	 public User findUserByEmail(String email);
	 User saveUser(User user);

}
