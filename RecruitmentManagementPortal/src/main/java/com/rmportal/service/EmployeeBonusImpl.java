package com.rmportal.service;

import java.util.Objects;

import org.apache.commons.lang3.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmportal.model.EmployeeReferal;
import com.rmportal.model.User;
import com.rmportal.repository.EmployeeReferalRepository;
import com.rmportal.repository.UserRepository;
import com.rmportal.requestModel.SetBonusRequestModel;
import com.rmportal.responseModel.EmployeeBonusStatusResponseModel;
import com.rmportal.utility.CalculateDifferenceInDate;
import com.rmportal.utility.ConversionUtility;
import com.rmportal.utility.CronJobSchedular;
import com.rmportal.utility.CustomException;

@Service
public class EmployeeBonusImpl implements EmployeeBonusService {

	@Autowired
	EmployeeReferalRepository employeeReferalRepo;

	@Autowired
	EmployeeReferalRepository employeeReferalBonusrepo;

	@Autowired
	CronJobSchedular cronJobSchedular;

	@Autowired
	ConversionUtility conversionUtility;

	@Autowired
	UserRepository userRepository;

	@Autowired
	CalculateDifferenceInDate calculateDifferenceInDate;

	// get candidate bonus
	@Override
	public EmployeeBonusStatusResponseModel getReferralBonus(int referal_id) throws CustomException {

		EmployeeReferal employeeReferal = employeeReferalRepo.findOne(referal_id);
		if (Objects.isNull(employeeReferal)) {
			throw new CustomException(204, " No Content Found for Specified Referral Id");
		}

		if (employeeReferal.getApplication_status().compareTo("Joined") != 0) {
			throw new CustomException(206, "Bonus is not applicable as candidate not yet joined the organization");
		}
		EmployeeBonusStatusResponseModel bonusResponse = conversionUtility.calculateBonus(employeeReferal);
		return bonusResponse;

	}

	// set employee bonus for the referred candidate
	@Override
	public String setBonus(SetBonusRequestModel setBonusRequestModel) throws CustomException {

		EmployeeReferal employeeReferal = employeeReferalRepo.findOne(setBonusRequestModel.getReferral_id());
		if (Objects.isNull(employeeReferal)) {
			throw new CustomException(204, " No Details Found for Specified Referral Id");
		}
		/*
		 * if (employeeReferal.getApplication_status().compareTo("Joined") != 0)
		 * { throw new CustomException(206, " Candidate is Still not Joined"); }
		 */

		User user = userRepository.findByEmail(setBonusRequestModel.getApplicant_email());
		if (Objects.isNull(user)) {
			throw new CustomException(204, " No Data Found Found for Specified Applicant Email");
		}
		if (!user.isActive()) {
			throw new CustomException(401, " User is inActive");
		} 
		
		return conversionUtility.setBonusConversion(employeeReferal, setBonusRequestModel); 
	}
}
