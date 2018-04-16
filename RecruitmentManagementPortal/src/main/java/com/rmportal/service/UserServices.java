package com.rmportal.service;

import com.rmportal.model.User;
<<<<<<< HEAD
import com.rmportal.responseModel.UserResponseDTO;
import com.rmportal.utility.CustomException;
=======
>>>>>>> 449418ecf4b0845254c9df22f775e5b21c1dd2bb

/**
 * @author tejas
 *
 */

public interface UserServices {

	 public User findUserByEmail(String email);
	 UserResponseDTO saveUser(User user) throws CustomException;

}
