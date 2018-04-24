package com.rmportal.service;

import org.springframework.web.multipart.MultipartFile;

import com.rmportal.requestModel.UploadResumeRequestModel;
import com.rmportal.responseModel.EmployeeReferalResponseModel;
import com.rmportal.responseModel.UploadResumeResponseModel;
import com.rmportal.utility.CustomException;

public interface EmployeeReferalService {
	
	/*public EmployeeReferalResponseModel getEmployeeDetails(int referal_id) throws CustomException;*/
	
	public EmployeeReferalResponseModel getEmployeeDetails(String referance_email ) throws CustomException;

	public UploadResumeResponseModel addResume(UploadResumeRequestModel uploadResumeRequestModel,
			MultipartFile file) throws CustomException;
}
