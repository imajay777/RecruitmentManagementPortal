package com.rmportal.service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmportal.model.EmployeeReferal;
import com.rmportal.repository.EmployeeReferalRepository;
import com.rmportal.responseModel.EmployeeBonusStatusResponseModel;
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
	CronJobSchedular  cronJobSchedular;

	@Autowired
	ConversionUtility conversionUtility;
	
	@Override
	public EmployeeBonusStatusResponseModel getReferralBonus(int referal_id) throws CustomException {

		EmployeeReferal employeeReferal = employeeReferalRepo.findOne(referal_id);
		if (Objects.isNull(employeeReferal)) {
			throw new CustomException(204, " No Content Found of Specified Referral Id");
		}

		
		if (employeeReferal.getApplication_status().compareTo("Joined") != 0) {
			throw new CustomException(206, " Bonus Cannot be applicable");
		}
		EmployeeBonusStatusResponseModel bonusResponse = conversionUtility.calculateBonus(employeeReferal);
		return bonusResponse;
		
	}

}
