package com.rmportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rmportal.constants.HttpStatusConstants;
import com.rmportal.responseModel.EmployeeReferalResponseModel;
import com.rmportal.responseModel.HttpResponseModel;
import com.rmportal.responseModel.UpdateResponseModel;
import com.rmportal.service.EmployeeReferalService;
import com.rmportal.utility.ConversionUtility;
import com.rmportal.utility.CustomException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author tejas
 *
 */
@RestController
@Api(value="EmployeeReferal Controller", description="Refer the Candidate")
@CrossOrigin("*")
public class EmployeeReferalController {
	
	@Autowired
	EmployeeReferalService employeeReferalServices;
	
	@Autowired
	ConversionUtility conversionUtility;
	
	/*@RequestMapping(value = "/getEmployeeDetails/{referal_id}", method = RequestMethod.GET)
	@ApiOperation(value="Get Employee Details")
	public ResponseEntity<?> getEmployeeDetails(@PathVariable("referal_id") int referal_id){
		
		EmployeeReferalResponseModel employeeReferalResponseModel = null; 
		
		try {
			employeeReferalResponseModel = employeeReferalServices.getEmployeeDetails(referal_id);
		} catch (CustomException e) {
			return ResponseEntity.ok(
					new HttpResponseModel(e.getMessage(), HttpStatusConstants.INTERNAL_SERVER_ERROR.id, employeeReferalResponseModel));
		}
		F
		return ResponseEntity.ok(new HttpResponseModel(HttpStatusConstants.OK.getStatus() + " Data Fetched Successfully",
				HttpStatusConstants.OK.id, employeeReferalResponseModel));
		
	}*/

	@RequestMapping(value = "/getEmployeeDetails", method = RequestMethod.POST)
	@ApiOperation(value="Get Employee Details")
	public ResponseEntity<?> getEmployeeDetails(@RequestParam("referance_email") String referance_email){
		
		System.out.println(referance_email);
		
		EmployeeReferalResponseModel employeeReferalResponseModel = null; 
		
		try {
			employeeReferalResponseModel = employeeReferalServices.getEmployeeDetails(referance_email);
		} catch (CustomException e) {
			return ResponseEntity.ok(
					new HttpResponseModel(e.getMessage(), HttpStatusConstants.INTERNAL_SERVER_ERROR.id, employeeReferalResponseModel));
		}
		
		return ResponseEntity.ok(new HttpResponseModel(HttpStatusConstants.OK.getStatus() + " Data Fetched Successfully",
				HttpStatusConstants.OK.id, employeeReferalResponseModel));
		
	}
}
