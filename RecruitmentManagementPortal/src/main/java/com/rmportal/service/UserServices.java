package com.rmportal.service;

import com.rmportal.model.User;

/**
 * @author tejas
 *
 */

public interface UserServices {

	 public User findUserByEmail(String email);
	 User saveUser(User user);

}
