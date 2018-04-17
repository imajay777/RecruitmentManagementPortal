package com.rmportal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rmportal.constants.HttpStatusConstants;
import com.rmportal.model.User;
import com.rmportal.requestModel.RegisterRequestModel;
import com.rmportal.responseModel.HttpResponseModel;
import com.rmportal.responseModel.UserResponseDTO;
import com.rmportal.service.UserServices;
import com.rmportal.utility.ConversionUtility;
import com.rmportal.utility.CustomException;

/**
 * @author tejas
 *
 */
@RestController
@CrossOrigin
public class RegisterController {

	@Autowired
	UserServices userService;

	@Autowired
	ConversionUtility conversionUtility;
	

	@RequestMapping(value = "/registration", method = RequestMethod.POST, consumes = "application/json")

	public ResponseEntity<?> registeration(@RequestBody @Valid RegisterRequestModel registerRequestModel,
			BindingResult bindingResult) {

		/*
		 * RegisterRequestModel
		 * userExits=userService.findUserByEmail(registerRequestModel.getEmail()
		 * );
		 * 
		 * if(userExits !=null){ bindingResult.rejectValue("email",
		 * "error.user", "There is already a registered user"); }
		 * 
		 * if(bindingResult.hasErrors()){
		 * 
		 * } return
		 */

		User user = conversionUtility.convertRequestToUser(registerRequestModel);
		UserResponseDTO httpResponseModel=null;
		try {
			httpResponseModel = userService.saveUser(user);
		} catch (CustomException e) {
			
			return ResponseEntity.ok(
					new HttpResponseModel(HttpStatusConstants.INTERNAL_SERVER_ERROR.getStatus() + "Invalid Email",
							HttpStatusConstants.INTERNAL_SERVER_ERROR.id, httpResponseModel));
		}

		return ResponseEntity.ok(new HttpResponseModel(HttpStatusConstants.OK.getStatus() + "Register successfully",
				HttpStatusConstants.OK.id, httpResponseModel));

	}
	
	/*try {
		httpResponseModel = loginService.validateUser(loginRequestModel);
	} catch (CustomException e) {
		return ResponseEntity.ok(
				new HttpResponseModel(HttpStatusConstants.INTERNAL_SERVER_ERROR.getStatus() + "Invalid credentials",
						HttpStatusConstants.INTERNAL_SERVER_ERROR.id, httpResponseModel));
	}
	return ResponseEntity.ok(new HttpResponseModel(HttpStatusConstants.OK.getStatus() + "Login successfully",
			HttpStatusConstants.OK.id, httpResponseModel));

}*/

}
