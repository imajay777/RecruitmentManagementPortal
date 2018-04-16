package com.rmportal.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rmportal.model.Role;
import com.rmportal.model.User;
import com.rmportal.repository.RoleRepository;
import com.rmportal.repository.UserRepository;
import com.rmportal.requestModel.RegisterRequestModel;
import com.rmportal.responseModel.UserResponseDTO;
import com.rmportal.utility.ConversionUtility;
import com.rmportal.utility.CustomException;

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

	@Autowired
	ConversionUtility conversionUtility;

	@Override
	public User findUserByEmail(String email) {
		return null;// userRepository.findByEmail(email);
	}

	public boolean isValidEmail(String email) {
		Pattern emailPattern = Pattern.compile("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$",
				Pattern.CASE_INSENSITIVE);

		Matcher m = emailPattern.matcher(email);

		return m.matches();

	}

	@Override
	public UserResponseDTO saveUser(User registerRequestModel) throws CustomException {

		registerRequestModel.setActive(false);
		Role userRole = roleRepository.findOne(3);
		registerRequestModel.setRoles(userRole);

		if (isValidEmail(registerRequestModel.getEmail())) {

			String str[] = registerRequestModel.getEmail().split("@");

			if (str[1].compareTo("agsft.com") == 0) {
				return conversionUtility.convertUserToresponse(registerRequestModel);
			} else {
				System.out.println("invalid");
				throw new CustomException(500, "invalid email");
			}

		} else {
			System.out.println("invalid");
			throw new CustomException();
		}
		/*
		 * User user = null; if
		 * (registerRequestModel.getEmail().contains("@agsft.com")) {
		 * System.out.println("the email is correct"); user =
		 * userRepository.save(registerRequestModel); return
		 * conversionUtility.convertUserToresponse(user); } else {
		 * System.out.println("the email is not correct"); } return null;
		 */

	}

}
