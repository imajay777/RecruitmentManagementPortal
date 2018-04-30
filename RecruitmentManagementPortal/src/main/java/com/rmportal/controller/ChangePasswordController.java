package com.rmportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rmportal.constants.HttpStatusConstants;
import com.rmportal.requestModel.ChangePasswordModel;
import com.rmportal.responseModel.HttpResponseModel;
import com.rmportal.responseModel.UserResponseDTO;
import com.rmportal.service.UserServices;
import com.rmportal.utility.CustomException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author saurabh Controller for Login, Forgot Password and Reset Password
 */

@RestController
@Api(value="User Upgradation", description="Change Details from Profile Page")
@CrossOrigin("*")
public class ChangePasswordController {

	@Autowired
	UserServices userService;
	
	// Change Password Controller
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	@ApiOperation(value = "Change Password")
	public ResponseEntity<?> changePassword(@RequestBody ChangePasswordModel changePasswordModel)
			throws CustomException {
		
		UserResponseDTO httpResponseModel = null;
		
		if(userService.changePassword(changePasswordModel)){
			return ResponseEntity
					.ok(new HttpResponseModel("Password Changed",
							HttpStatusConstants.OK.id, null));
		}

		return ResponseEntity
				.ok(new HttpResponseModel("Invalid Token or Email",
						HttpStatusConstants.INTERNAL_SERVER_ERROR.id, null));

	}
}
