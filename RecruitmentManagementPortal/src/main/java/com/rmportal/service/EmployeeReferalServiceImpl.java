package com.rmportal.service;

import java.io.IOException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rmportal.model.EmployeeReferal;
import com.rmportal.repository.EmployeeReferalRepository;
import com.rmportal.requestModel.UploadResumeRequestModel;
import com.rmportal.responseModel.EmployeeReferalResponseModel;
import com.rmportal.responseModel.UploadResumeResponseModel;
import com.rmportal.utility.ConversionUtility;
import com.rmportal.utility.CustomException;

@Service
public class EmployeeReferalServiceImpl implements EmployeeReferalService {

	@Autowired
	ConversionUtility conversionUtility;

	@Autowired
	EmployeeReferalRepository employeeReferalRepository;

	@Override
	public UploadResumeResponseModel addResume(UploadResumeRequestModel uploadResumeRequestModel, MultipartFile file)
			throws CustomException {

		EmployeeReferal employeeReferal = null;
		UploadResumeResponseModel uploadResumeResponseModel = null;

		try {
			employeeReferal = conversionUtility.addEmployeeResume(uploadResumeRequestModel, file);

			if (Objects.isNull(employeeReferal)) {
				throw new CustomException(204, "No content filled");
			}

			employeeReferalRepository.save(employeeReferal);
			uploadResumeResponseModel = new UploadResumeResponseModel();
			uploadResumeResponseModel.setReference_id(employeeReferal.getReferal_id());
			uploadResumeResponseModel.setApplicant_name(employeeReferal.getApplicant_name());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return uploadResumeResponseModel;
	}

	@Override
	public EmployeeReferalResponseModel getEmployeeDetails(String referance_email) throws CustomException {
		EmployeeReferal employeeReferal = employeeReferalRepository.findByEmployeeEmail(referance_email);

		if (Objects.isNull(employeeReferal)) {
			throw new CustomException(500, " Unable to fetch Details");
		}
		return conversionUtility.convertTOGetEmployees(employeeReferal);
	}

}
