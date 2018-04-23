package com.rmportal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rmportal.constants.HttpStatusConstants;
import com.rmportal.responseModel.HttpResponseModel;
import com.rmportal.responseModel.UpdateResponseModel;
import com.rmportal.utility.CustomException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="EmployeeReferal Controller", description="Refer the Candidate")
@CrossOrigin("*")
public class EmployeeReferalController {
	
	/*@RequestMapping(value = "/getEmployeeDetails/{referal_id}", method = RequestMethod.GET)
	@ApiOperation(value="Get Employee Details")
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
		
	}*/

}
