package com.rmportal.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rmportal.model.Role;
import com.rmportal.model.User;
import com.rmportal.repository.RoleRepository;
import com.rmportal.repository.UserRepository;
import com.rmportal.requestModel.RegisterRequestModel;
import com.rmportal.responseModel.UpdateResponseModel;
import com.rmportal.responseModel.UserResponseDTO;
import com.rmportal.utility.ActivationEmailUtility;
import com.rmportal.utility.ConversionUtility;
import com.rmportal.utility.CustomException;
import com.rmportal.utility.PasswordEncryption;

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

	/*
	 * @Autowired PasswordEncryption passwordEncryption;
	 */

	private static List<User> users;

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

				User user = userRepository.findByEmail(registerRequestModel.getEmail());
				if (user != null)
					throw new CustomException(500, "User already exists");
				/* passwordEncryption.hashEncoder(registerRequestModel); */
				user = userRepository.save(registerRequestModel);
				// ActivationEmailUtility.sendingEmail();
				return conversionUtility.convertUserToresponse(user);
			} else {
				System.out.println("invalid");
				throw new CustomException(500, "invalid email");
			}

		} else {
			System.out.println("invalid");
			throw new CustomException();
		}

	}

	@Override
	public User FindById(long id) {
		return null;
	}

	@Override
	public UpdateResponseModel updateUser(int id, User user) throws CustomException {
		//User userObj;
		if (user != null) {

			User updatedUser = userRepository.findByUserId(id);
			user.setId(updatedUser.getId());
			 userRepository.save(user);
			//System.out.println(user);
		//	System.out.println(userObj);

		} else {
			throw new CustomException(500, "already exits");
		}
		return null;
	}

	@Override
	public List<User> getAllUsers() {

		System.out.println("hello");
		List<User> getUsers = (List<User>) userRepository.findAll();

		return getUsers;
	}

	@Override
	public boolean updateStatus(boolean status, String email) {
		User user = userRepository.findByEmail(email);
		if (user != null) {
			user.setActive(true);
			return true;
		}
		return false;
	}

}
