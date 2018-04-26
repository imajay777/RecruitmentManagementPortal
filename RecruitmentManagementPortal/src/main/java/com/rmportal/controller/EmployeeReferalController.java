package com.rmportal.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rmportal.constants.HttpStatusConstants;
import com.rmportal.repository.EmployeeReferalRepository;
import com.rmportal.requestModel.UploadResumeRequestModel;
import com.rmportal.responseModel.EmployeeReferalResponseModel;
import com.rmportal.responseModel.HttpResponseModel;
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
@Api(value = "EmployeeReferal Controller", description = "Refer the Candidate")
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
	@Autowired
	EmployeeReferalRepository employeeReferalRepo;

	@RequestMapping(value = "/addResume", method = RequestMethod.POST)
	@ApiOperation(value = "Upload Resume")
	public ResponseEntity<?> uploadResume(@RequestBody UploadResumeRequestModel uploadResumeModel,
			@RequestParam("file") MultipartFile file) {

		if (file.isEmpty()) {
			return ResponseEntity.ok(new HttpResponseModel(HttpStatus.NO_CONTENT.name() + " Please Upload File",
					HttpStatusConstants.OK.id, null));
		}

		if (Objects.isNull(uploadResumeModel)){
			return ResponseEntity.ok(new HttpResponseModel(HttpStatus.NO_CONTENT.name() + " Please Fill the Details",
					HttpStatusConstants.OK.id, null));
		}
		
		
		
		/*if (file != null) {
			

				EmployeeReferal employeeReferal = new EmployeeReferal();
				employeeReferal.;
				employeeReferalRepo.save(employeeReferal);
			
		}*/

		return null;
	}

}
