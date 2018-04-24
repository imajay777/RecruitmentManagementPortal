package com.rmportal.service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.rmportal.requestModel.UploadResumeRequestModel;
import com.rmportal.responseModel.UploadResumeResponseModel;
import com.rmportal.utility.CustomException;


public interface EmployeeReferalService {

	public UploadResumeResponseModel addResume(UploadResumeRequestModel uploadResumeRequestModel,
			MultipartFile file) throws CustomException;
}
