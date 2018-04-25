package com.rmportal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rmportal.constants.HttpStatusConstants;
import com.rmportal.model.User;
import com.rmportal.requestModel.RegisterRequestModel;
import com.rmportal.requestModel.UpdateRequestModel;
import com.rmportal.responseModel.HttpResponseModel;
import com.rmportal.responseModel.UpdateResponseModel;
import com.rmportal.responseModel.UserResponseDTO;
import com.rmportal.service.UserServices;
import com.rmportal.utility.ConversionUtility;
import com.rmportal.utility.CustomException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author tejas
 *
 */
@RestController
@Api(value="Registration Controller", description="Registration Process")
@CrossOrigin("*")

public class RegisterController {

	@Autowired
	UserServices userService;

	@Autowired
	ConversionUtility conversionUtility;

	// Registration API
	@RequestMapping(value = "/registration", method = RequestMethod.POST, consumes = "application/json")
	@ApiOperation(value="User Registration")
	public ResponseEntity<?> registeration(@RequestBody @Valid RegisterRequestModel registerRequestModel,
			BindingResult bindingResult) {

		User user = conversionUtility.convertRequestToUser(registerRequestModel);
		UserResponseDTO httpResponseModel = null;

		try {
			httpResponseModel = userService.saveUser(user);
		} catch (CustomException e) {

			return ResponseEntity
					.ok(new HttpResponseModel(HttpStatusConstants.INTERNAL_SERVER_ERROR.getStatus() + e.getMessage(),
							HttpStatusConstants.INTERNAL_SERVER_ERROR.id, httpResponseModel));
		}

		return ResponseEntity.ok(new HttpResponseModel(HttpStatusConstants.OK.getStatus() + "Register successfully",
				HttpStatusConstants.OK.id, httpResponseModel));

	}

	// UpdateUser API
	@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.POST, consumes = "application/json")
	@ApiOperation(value="Update User")
	public ResponseEntity<?> updateUser(@PathVariable("id") int id, @RequestBody UpdateRequestModel updateRequestModel)
			throws CustomException {

		User user = conversionUtility.convertRequestToUser(updateRequestModel);

		UpdateResponseModel updateResponseModel = userService.updateUser(id, user);

		return ResponseEntity.ok(new HttpResponseModel(HttpStatusConstants.OK.getStatus() + "updated successfully",
				HttpStatusConstants.OK.id, updateResponseModel));
	}

	// Process Activation link while Registration
	@RequestMapping(value = "/activation", method = RequestMethod.GET)
	@ApiOperation(value="Validate Token")
	public ResponseEntity<?> validateToken(@RequestParam("token") String token, @RequestParam("userId") int userId)
			throws CustomException {


		if (userService.validateUserToken(userId, token)) {
			return ResponseEntity.ok(new HttpResponseModel(HttpStatusConstants.OK.getStatus() + "User Activated",
					HttpStatusConstants.OK.id, null));
		}

		return ResponseEntity
				.ok(new HttpResponseModel(HttpStatusConstants.INTERNAL_SERVER_ERROR.getStatus() + "Invalid Token",
						HttpStatusConstants.INTERNAL_SERVER_ERROR.id, null));

	}

	// List of Users API
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	@ApiOperation(value="Get List of Users")
	public ResponseEntity<?> listAllUsers() {
		List<User> users = userService.getAllUsers();
		/*
		 * if (users.isEmpty()) { return
		 * ResponseEntity.ok(HttpStatus.NO_CONTENT); // You many decide to
		 * return HttpStatus.NOT_FOUND }
		 */
		return ResponseEntity.ok(new HttpResponseModel(HttpStatusConstants.OK.getStatus() + "users fetched",
				HttpStatusConstants.OK.id, users));
	}

	// UserStatus Activation/Deactivation API through page
	@RequestMapping(value = "/updateStatus/{status}", method = RequestMethod.GET)
	@ApiOperation(value="Activation/Deactivation")
	public ResponseEntity<?> updateStatus(@PathVariable boolean status, @RequestParam(required = true) String email) {
		if (userService.updateStatus(status, email)) {

			return ResponseEntity.ok(new HttpResponseModel(HttpStatusConstants.OK.getStatus() + "status updated",
					HttpStatusConstants.OK.id, true));
		}

		return ResponseEntity.ok(new HttpResponseModel(HttpStatusConstants.OK.getStatus() + "invalid user",
				HttpStatusConstants.OK.id, false));

	}
	
	// Get User Details
	@RequestMapping(value = "/getDetails/{user_id}", method = RequestMethod.GET)
	@ApiOperation(value="Get User Details")
	public ResponseEntity<?> getDetails(@PathVariable("user_id") int user_id){
		
		UpdateResponseModel updateResponseModel = null; 
		
		try {
			updateResponseModel = userService.getDetails(user_id);
		} catch (CustomException e) {
			return ResponseEntity.ok(
					new HttpResponseModel(e.getMessage(), HttpStatusConstants.INTERNAL_SERVER_ERROR.id, updateResponseModel));
		}
		
		return ResponseEntity.ok(new HttpResponseModel(HttpStatusConstants.OK.getStatus() + " Data Fetched Successfully",
				HttpStatusConstants.OK.id, updateResponseModel));
		
	}
	 
}
