package com.rmportal.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.rmportal.model.EmployeeReferal;
import com.rmportal.requestModel.UploadResumeRequestModel;
import com.rmportal.responseModel.EmployeeReferalResponseModel;
import com.rmportal.responseModel.UploadResumeResponseModel;
import com.rmportal.utility.CustomException;

/**
 * @author saurabh
 *
 */
public interface EmployeeReferalService {

	/*
	 * public EmployeeReferalResponseModel getEmployeeDetails(int referal_id)
	 * throws CustomException;
	 */

	public EmployeeReferalResponseModel getEmployeeDetails(String referance_email) throws CustomException;

	public UploadResumeResponseModel addResume(UploadResumeRequestModel uploadResumeRequestModel, MultipartFile file)
			throws CustomException;

	public EmployeeReferal fetchResume(int job_vacancy_id);

	public List<EmployeeReferalResponseModel> getEmployeeReferalList() throws CustomException;
}
