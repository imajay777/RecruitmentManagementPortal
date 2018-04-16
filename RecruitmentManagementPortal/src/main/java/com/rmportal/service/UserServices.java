package com.rmportal.service;

import com.rmportal.model.User;
import com.rmportal.responseModel.UserResponseDTO;
import com.rmportal.utility.CustomException;

/**
 * @author tejas
 *
 */

public interface UserServices {

	 public User findUserByEmail(String email);
	 UserResponseDTO saveUser(User user) throws CustomException;

}
