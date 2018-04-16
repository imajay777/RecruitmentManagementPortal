package com.rmportal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rmportal.requestModel.LoginRequestModel;
import com.rmportal.responseModel.LoginResponseModel;
import com.rmportal.service.LoginServices;

/**
 * @author saurabh
 *
 */

@RestController
public class LoginController {

	@Autowired
	public LoginServices loginService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public LoginResponseModel login(HttpServletRequest request, HttpServletResponse response,
			@RequestBody LoginRequestModel loginRequestModel) {

		LoginResponseModel user = loginService.validateUser(loginRequestModel);
		return user;
	}
}
