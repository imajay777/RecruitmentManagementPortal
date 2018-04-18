package com.rmportal.service;

import java.util.List;

import com.rmportal.model.User;
import com.rmportal.responseModel.UpdateResponseModel;
import com.rmportal.responseModel.UserResponseDTO;
import com.rmportal.utility.CustomException;

/**
 * @author tejas
 *
 */

public interface UserServices {

	public User findUserByEmail(String email);

	UserResponseDTO saveUser(User user) throws CustomException;

	public User FindById(long id);

	

	public UpdateResponseModel updateUser(int id, User user) throws CustomException;
	
	public List<User> getAllUsers();
	
	public boolean updateStatus(boolean status, String email);  

}
