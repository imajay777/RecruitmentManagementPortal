package com.rmportal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rmportal.model.User;
import com.rmportal.requestModel.RegisterRequestModel;
import com.rmportal.service.UserServices;
import com.rmportal.utility.ConversionUtility;


/**
 * @author tejas
 *
 */
@RestController
public class RegisterController {

	@Autowired
	UserServices userService;

	@Autowired
	ConversionUtility conversionUtility;

	@RequestMapping(value = "/registration", method = RequestMethod.POST, consumes = "application/json")
	public User registeration(@RequestBody @Valid RegisterRequestModel registerRequestModel, BindingResult bindingResult) {
		
		User user = conversionUtility.convertRequestToUser(registerRequestModel);
		User resp = userService.saveUser(user);
		return resp;

	}

}
