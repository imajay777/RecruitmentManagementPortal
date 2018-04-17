package com.rmportal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rmportal.constants.HttpStatusConstants;
import com.rmportal.requestModel.LoginRequestModel;
import com.rmportal.responseModel.HttpResponseModel;
import com.rmportal.responseModel.ResponseModel;
import com.rmportal.service.LoginServices;
import com.rmportal.utility.CustomException;

/**
 * @author saurabh
 *
 */

@RestController
@CrossOrigin
public class LoginController {

	@Autowired
	public LoginServices loginService;

	

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> login(HttpServletRequest request, HttpServletResponse response,
			@RequestBody LoginRequestModel loginRequestModel) {

		ResponseModel responseModel = null;
		try {
			responseModel = loginService.validateUser(loginRequestModel);
		} catch (CustomException e) {
			return ResponseEntity.ok(
					new HttpResponseModel(HttpStatusConstants.INTERNAL_SERVER_ERROR.getStatus() + "Invalid credentials",
							HttpStatusConstants.INTERNAL_SERVER_ERROR.id, responseModel));
		}
		return ResponseEntity.ok(new HttpResponseModel(HttpStatusConstants.OK.getStatus() + "Login successfully",
				HttpStatusConstants.OK.id, responseModel));

	}
}
