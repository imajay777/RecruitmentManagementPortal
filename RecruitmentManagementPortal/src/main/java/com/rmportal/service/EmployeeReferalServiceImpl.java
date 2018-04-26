package com.rmportal.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.mail.Multipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rmportal.model.EmployeeReferal;
import com.rmportal.repository.EmployeeReferalRepository;
import com.rmportal.requestModel.ReferralStatusRequestModel;
import com.rmportal.requestModel.UploadResumeRequestModel;
import com.rmportal.responseModel.ChangeReferralStatusResponse;
import com.rmportal.responseModel.EmployeeReferalResponseModel;
import com.rmportal.responseModel.UploadResumeResponseModel;
import com.rmportal.utility.ConversionUtility;
import com.rmportal.utility.CustomException;

/**
 * @author saurabh
 *
 */
@Service
public class EmployeeReferalServiceImpl implements EmployeeReferalService {

	@Autowired
	ConversionUtility conversionUtility;

	@Autowired
	EmployeeReferalRepository employeeReferalRepository;

	// Upload Resume
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
			uploadResumeResponseModel.setDate(employeeReferal.getDate());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return uploadResumeResponseModel;
	}

	// Get details of Referred Candidate
	@Override
	public List<EmployeeReferalResponseModel> getEmployeeDetails(String referance_email) throws CustomException {
		List<EmployeeReferal> employeeReferal = employeeReferalRepository.findByEmployeeEmail(referance_email);

		if (Objects.isNull(employeeReferal)) {
			throw new CustomException(500, " Unable to fetch Details");
		}
		return conversionUtility.convertTOGetEmployees(employeeReferal);
	}

	// Retrieve the Resume from database
	@Override
	public EmployeeReferal fetchResume(int job_vacancy_id) {

		EmployeeReferal employeeReferal = employeeReferalRepository.findOne(job_vacancy_id);

		return employeeReferal;
	}

	// Get List of All Application candidate
	@Override
	public List<EmployeeReferalResponseModel> getEmployeeReferalList() throws CustomException {
		// TODO Auto-generated method stub
		List<EmployeeReferal> empReferal = (List<EmployeeReferal>) employeeReferalRepository.findAll();
		return conversionUtility.getAllEmployeeReferal(empReferal);
		// return null;
	}

	// Change the Referral Status
	@Override
	public ChangeReferralStatusResponse setReferralStatus(ReferralStatusRequestModel referralStatusRequestModel) throws CustomException {
		EmployeeReferal employeeReferal = employeeReferalRepository.findOne(referralStatusRequestModel.getReferal_id());
		if (Objects.isNull(employeeReferal)) {
			throw new CustomException(204, "No Data Found");
		}

		employeeReferal.setApplication_status(referralStatusRequestModel.getReferral_status());
		Date date = new Date();
		employeeReferal.setDate(date);
		employeeReferalRepository.save(employeeReferal);
		ChangeReferralStatusResponse changeReferralResponse = new ChangeReferralStatusResponse();
		changeReferralResponse.setDate(employeeReferal.getDate());
		changeReferralResponse.setApplicant_name(employeeReferal.getApplicant_name());
		return changeReferralResponse;
	}
}
