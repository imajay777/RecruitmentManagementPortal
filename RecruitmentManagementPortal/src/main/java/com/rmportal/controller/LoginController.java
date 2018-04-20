package com.rmportal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rmportal.constants.HttpStatusConstants;
import com.rmportal.model.User;
import com.rmportal.requestModel.LoginRequestModel;
import com.rmportal.requestModel.ResetPasswordModel;
import com.rmportal.responseModel.HttpResponseModel;
import com.rmportal.responseModel.ResponseModel;
import com.rmportal.service.LoginServices;
import com.rmportal.service.UserServices;
import com.rmportal.utility.CustomException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author saurabh
 * Controller for Login, Forgot Password and Reset Password
 */

@RestController
@Api(value="Login Controller", description="Login details")
@CrossOrigin("*")
public class LoginController {

	@Autowired
	public LoginServices loginService;

	@Autowired
	UserServices userService;

	// Login Controller
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ApiOperation(value="Login Controller")
	public ResponseEntity<?> login(HttpServletRequest request, HttpServletResponse response,
			@RequestBody LoginRequestModel loginRequestModel) {

		ResponseModel responseModel = null;
		
		try {
			responseModel = loginService.validateUser(loginRequestModel);
			
		} catch (CustomException e) {
			return ResponseEntity.ok(
					new HttpResponseModel(e.getMessage(), HttpStatusConstants.INTERNAL_SERVER_ERROR.id, responseModel));
		}
		return ResponseEntity.ok(new HttpResponseModel(HttpStatusConstants.OK.getStatus() + " Login Successful",
				HttpStatusConstants.OK.id, responseModel));

	}

	// Forget Password Controller
	@RequestMapping(value = "/forgetPassword/{email}", method = RequestMethod.GET)
	@ApiOperation(value="Forget Password")
	public ResponseEntity<?> forgetPassword(@PathVariable("email") String email) throws CustomException {


		if (userService.forgetPassword(email)) {
			return ResponseEntity
					.ok(new HttpResponseModel(HttpStatusConstants.OK.getStatus() + " Link Sent to your Email Address",
							HttpStatusConstants.OK.id, null));
		}

		return ResponseEntity
				.ok(new HttpResponseModel(HttpStatusConstants.INTERNAL_SERVER_ERROR.getStatus() + "Invalid Email",
						HttpStatusConstants.INTERNAL_SERVER_ERROR.id, null));
	}
	
	// Reset Password Controller
	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	@ApiOperation(value="Reset Password")
	public ResponseEntity<?> resetPassword(HttpServletRequest request, HttpServletResponse response,
			@RequestBody ResetPasswordModel resetPasswordModel) throws CustomException {


		if (userService.resetPassword(resetPasswordModel)) {
			return ResponseEntity
					.ok(new HttpResponseModel(HttpStatusConstants.OK.getStatus() + " Password Reset",
							HttpStatusConstants.OK.id, null));
		}

		return ResponseEntity
				.ok(new HttpResponseModel(HttpStatusConstants.INTERNAL_SERVER_ERROR.getStatus() + " Invalid Token or Email",
						HttpStatusConstants.INTERNAL_SERVER_ERROR.id, null));

	}
}
