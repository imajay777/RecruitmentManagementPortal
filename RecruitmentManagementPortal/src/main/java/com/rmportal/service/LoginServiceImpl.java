package com.rmportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rmportal.constants.HttpStatusConstants;
import com.rmportal.model.Role;
import com.rmportal.model.User;
import com.rmportal.repository.UserRepository;
import com.rmportal.requestModel.LoginRequestModel;
import com.rmportal.responseModel.ResponseModel;
import com.rmportal.utility.ConversionUtility;
import com.rmportal.utility.CustomException;

/**
 * @author saurabh
 *
 */

@Service
public class LoginServiceImpl implements LoginServices {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ConversionUtility conversionUtility;

	@Autowired
	PasswordEncoder bCryptPassword;

	@Override
	public ResponseModel validateUser(LoginRequestModel loginRequestModel) throws CustomException {

		User user = userRepository.findByEmail(loginRequestModel.getEmail());

		if (user == null) {
			throw new CustomException(HttpStatusConstants.NO_CONTENT.id, HttpStatusConstants.NO_CONTENT.getStatus());
		}
		if (user.isActive()) {

			if (bCryptPassword.matches(loginRequestModel.getPassword(), user.getPassword())) {
				
				
				
				return conversionUtility.convertUserToResponse(user);

				// UserPremissionModel userPremissionModel =
				// userPermissionRepository.findByRoleAndPermission(responseModel.getRole().getId());
				// Role role = userFromTable.getRoles();

				// responseModel.setRole(role);
				

			} else {
				throw new CustomException(401, "Invalid Password");
			}
		} else {
			throw new CustomException(406, "User is Inactive");
		}

	}

}
