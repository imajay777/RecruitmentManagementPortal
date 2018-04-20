package com.rmportal.service;

import java.util.Objects;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rmportal.constants.UserTokenType;
import com.rmportal.model.Role;
import com.rmportal.model.User;
import com.rmportal.model.UserToken;
import com.rmportal.repository.RoleRepository;
import com.rmportal.repository.UserRepository;
import com.rmportal.repository.UserTokenRepository;
import com.rmportal.requestModel.ChangePasswordModel;
import com.rmportal.requestModel.ResetPasswordModel;
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
	@Autowired
	ActivationEmailUtility activationEmailUtility;

	@Autowired
	UserTokenRepository userTokenRepository;

	@Autowired
	ForgetPasswordEmailUtility forgotPasswordEmailUtility;

	@Autowired
	PasswordEncryption passwordEncryption;

	@Autowired
	PasswordEncoder bCryptPassword;

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
				user = userRepository.save(registerRequestModel);
				activationEmailUtility.sendMail(user);

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
		// User userObj;
		if (user != null) {

			User updatedUser = userRepository.findByUserId(id);
			user.setId(updatedUser.getId());
			userRepository.save(user);
			// System.out.println(user);
			// System.out.println(userObj);

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

	public boolean validateUserToken(int userId, String token) throws CustomException {

		if (StringUtils.isEmpty(token)) {
			throw new CustomException(500, "Token is not found");
		} else {
			UserToken tokenObj = userTokenRepository.findByTokenValue(token);
			if (Objects.isNull(tokenObj)) {
				throw new CustomException(500, "Token is Null");
			}

			if (tokenObj.getTokenType().compareTo(UserTokenType.ADD_USER.name()) != 0) {
				throw new CustomException(500, "Token Type Mismatch");
			}

			User user = userRepository.findByUserId(userId);
			user.setActive(true);
			userTokenRepository.delete(tokenObj);
			return true;
		}

	}

	@Override
	public boolean forgetPassword(String email) throws CustomException {
		User user = userRepository.findByEmail(email);
		if (user != null && user.isActive()) {
			forgotPasswordEmailUtility.sendMail(user);
			return true;
		}
		return false;
	}

	@Override
	public boolean resetPassword(ResetPasswordModel resetPasswordModel) throws CustomException {
		UserToken userToken = userTokenRepository.findByToken(resetPasswordModel.getUserId(),
				resetPasswordModel.getToken());

		System.out.println(userToken);
		if (userToken != null && userToken.getTokenType().compareTo(UserTokenType.RESET_PASSWORD.name()) == 0) {
			User user = userRepository.findByUserId(userToken.getUser_id());

			if (user == null)
				throw new CustomException(500, "Token Not Foung OR Invalid TokenType");

			if (resetPasswordModel.getPassword().length() > 15)
				throw new CustomException(413, "Password Length too Long");

			user.setPassword(passwordEncryption.hashEncoder(resetPasswordModel.getPassword()));
			userTokenRepository.delete(userToken);
			return true;

		} else {
			return false;
		}

	}

	@Override
	public boolean changePassword(ChangePasswordModel changePasswordModel) throws CustomException {
		User user = userRepository.findByEmail(changePasswordModel.getEmail());
		if (Objects.isNull(user) && !user.isActive())
			throw new CustomException(500, "User is InActive");

		if (!bCryptPassword.matches(changePasswordModel.getOldPassword(), user.getPassword()))
			throw new CustomException(500, "Old Password did not match");

		user.setPassword(passwordEncryption.hashEncoder(changePasswordModel.getNewPassword()));
		return true;

	}

	@Override
	public UpdateResponseModel getDetails(int user_id) throws CustomException {
		User user = userRepository.findByUserId(user_id);
		if (Objects.isNull(user)) {
			throw new CustomException(500, "Invalid Email ID. Unable to fetch Details");
		}
		return conversionUtility.convertForUpdateResponse(user);
	}
}
