package com.rmportal.service;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rmportal.constants.UserTokenType;
import com.rmportal.model.Department;
import com.rmportal.model.Role;
import com.rmportal.model.User;
import com.rmportal.model.UserToken;
import com.rmportal.repository.DepartmentRepository;
import com.rmportal.repository.RoleRepository;
import com.rmportal.repository.UserRepository;
import com.rmportal.repository.UserTokenRepository;
import com.rmportal.requestModel.ChangePasswordModel;
import com.rmportal.requestModel.ResetPasswordModel;
import com.rmportal.requestModel.UpdateRequestModel;
import com.rmportal.responseModel.UpdateResponseModel;
import com.rmportal.responseModel.UserResponseDTO;
import com.rmportal.utility.ActivationEmailUtility;
import com.rmportal.utility.ConversionUtility;
import com.rmportal.utility.CustomException;
import com.rmportal.utility.ForgetPasswordEmailUtility;
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

	@Autowired
	DepartmentRepository departmentRepository;

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

		Department dept = departmentRepository.findOne(1);
		//registerRequestModel.setDepartments(dept);

		if (userRole == null) {
			throw new CustomException(500, "Role does not exits");
		}
		registerRequestModel.setRoles(userRole);

		if (isValidEmail(registerRequestModel.getEmail())) {

			String str[] = registerRequestModel.getEmail().split("@");

			if (str[1].compareTo("agsft.com") == 0) {

				User user = userRepository.findByEmail(registerRequestModel.getEmail());
				if (user != null)
					throw new CustomException(500, "User already exists");
				/* passwordEncryption.hashEncoder(registerRequestModel); */
				user = userRepository.save(registerRequestModel);
				activationEmailUtility.sendMail(user);

				return conversionUtility.convertUserToresponse(user);
			} else {
				throw new CustomException(500, "invalid email");
			}

		} else {
			throw new CustomException();
		}

	}

	@Override
	public User FindById(long id) {
		return null;
	}

	@Override
	public User updateUser(int id,UpdateRequestModel updateRequestModel) throws CustomException {
		
		
		User updatedUser = userRepository.findByUserId(id);
		
		if (updateRequestModel != null) {
			//System.out.println("user details"+user);

			if(updateRequestModel.getFirstName()==null)
			{
				throw new CustomException(HttpStatus.NOT_FOUND.value(), " First name can not be null");
				//throw new CustomException(500, " First name can not be null");
			}
			else
			{
				updatedUser.setFirstName(updateRequestModel.getFirstName());
			}
			if(updateRequestModel.getLastName()==null)
			{
				throw new CustomException(HttpStatus.NOT_FOUND.value(), " last name can not be null");
			}
			else
			{
				updatedUser.setLastName(updateRequestModel.getLastName());
			}

			
			updatedUser.setEmployee_id("Not Set");
//			updatedUser.setDepartments(updatedUser.getDepartments());
		//	updatedUser.setDepartments(updateRequestModel.getDepartment());
			if(updateRequestModel.getAddress()==null)
			{
				throw new CustomException(HttpStatus.NOT_FOUND.value(),"mension the proper address");
			}
			else
			{
			updatedUser.setAddress(updateRequestModel.getAddress());
			}
			if(updateRequestModel.getBlood_group()==null)
			{
				throw new CustomException(HttpStatus.NOT_FOUND.value(),"specify the blood group");
			}
			else
			{
			updatedUser.setBlood_group(updateRequestModel.getBlood_group());
			}
			if(updateRequestModel.getCity()==null)
			{
				throw new CustomException(HttpStatus.NOT_FOUND.value(),"mension the city");
			}
			else
			{
			updatedUser.setCity(updateRequestModel.getCity());
			}
			if(updateRequestModel.getCountry()==null)
			{
				throw new CustomException(HttpStatus.NOT_FOUND.value(),"mension the country");
			}
			else
			{
			updatedUser.setCountry(updateRequestModel.getCountry());
			}
			updatedUser.setMobile(updateRequestModel.getMobile());
			updatedUser.setDOB(updateRequestModel.getDateOfBirth());
			
			
			userRepository.save(updatedUser);	
			//conversionUtility.convertForUpdateResponse(user);
		//	userRepository.save(user);
			//response = "user updated succesfully";
			
		} else {
			throw new CustomException(500, " User already exits");
			
		}
		/*UpdateResponseModel updateResponseModel = conversionUtility.convertToUpdateResponseModel(user);
		return updateResponseModel;*/
		return updatedUser;
	}

	@Override
	public List<User> getAllUsers() throws CustomException {

		// System.out.println("hello");
		List<User> getUsers = (List<User>) userRepository.findAll();
		if(getUsers==null)
		{
			throw new CustomException(500,"no users are presents");
		}

		return getUsers;
	}

	@Override
	public boolean updateStatus(boolean status, String email) throws CustomException {
		System.out.println("email"+email);
		User user = userRepository.findByEmail(email);
	    if(user==null)
	    {
	    	throw new CustomException(HttpStatus.NOT_FOUND.value(), "user doesn't exits");
	    }
		if(user.isActive()&&status)
		{
			throw new CustomException(HttpStatus.NOT_FOUND.value(), "user alerady activated");
		}
		if(!user.isActive()&&!status)
		{
			throw new CustomException(HttpStatus.NOT_FOUND.value(), "user already deactivated");
		}
		user.setActive(status);
		userRepository.save(user);
		return user.isActive();

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
		} else {
			throw new CustomException(213, "User is Not Available");
		}
	}

	@Override
	public boolean resetPassword(ResetPasswordModel resetPasswordModel) throws CustomException {
		UserToken userToken = userTokenRepository.findByToken(resetPasswordModel.getUserId(),
				resetPasswordModel.getToken());

		System.out.println(userToken);
		if (userToken != null && userToken.getTokenType().compareTo(UserTokenType.RESET_PASSWORD.name()) == 0) {
			User user = userRepository.findByUserId(userToken.getUser_id());

			if (user == null)
				throw new CustomException(500, "Token Not Found OR Invalid TokenType");

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
		if (Objects.isNull(user) || !user.isActive())
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
