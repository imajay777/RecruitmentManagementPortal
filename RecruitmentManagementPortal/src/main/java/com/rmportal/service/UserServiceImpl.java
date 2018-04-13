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

		registerRequestModel.setActive(true);
		Role userRole = roleRepository.findByRole("ADMIN");
		// user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));

		return userRepository.save(registerRequestModel);
		
	}

	/*
	 * @Override public void saveUser(User user) {
	 * 
	 * user.setPassword((user.getPassword())); Role userRole =
	 * roleRepository.findByRole("ADMIN"); user.setRoles(new
	 * HashSet<Role>(Arrays.asList(userRole))); userRepository.save(user);
	 */

}
