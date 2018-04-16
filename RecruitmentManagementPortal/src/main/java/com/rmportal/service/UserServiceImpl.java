package com.rmportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rmportal.model.Role;
import com.rmportal.model.User;
import com.rmportal.repository.RoleRepository;
import com.rmportal.repository.UserRepository;

/**
 * @author tejas
 *
 */

@Service
@Transactional
public class UserServiceImpl implements UserServices {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Override
	public User findUserByEmail(String email) {
		return null;// userRepository.findByEmail(email);
	}

	@Override
	public User saveUser(User registerRequestModel) {

		registerRequestModel.setActive(false);
		Role userRole = roleRepository.findOne(3);
		registerRequestModel.setRoles(userRole);
		sendingEmail
		return userRepository.save(registerRequestModel);
		
	}

	
	 
}
