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
	CronJobSchedular  cronJobSchedular;

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
			throw new CustomException(204, " No Content Found of Specified Referral Id");
		}

		
		if (employeeReferal.getApplication_status().compareTo("Joined") != 0) {
			throw new CustomException(206, " Bonus Cannot be applicable");
		}
		EmployeeBonusStatusResponseModel bonusResponse = conversionUtility.calculateBonus(employeeReferal);
		return bonusResponse;
		
	}

	// set employee bonus for the referred candidate
	@Override
	public String setBonus(SetBonusRequestModel setBonusRequestModel) throws CustomException {

		EmployeeReferal employeeReferal = employeeReferalRepo.findOne(setBonusRequestModel.getReferral_id());
		if (Objects.isNull(employeeReferal)) {
			throw new CustomException(204, " No Content Found of Specified Referral Id");
		}
		/*if (employeeReferal.getApplication_status().compareTo("Joined") != 0) {
			throw new CustomException(206, " Candidate is Still not Joined");
		}*/
		
		User user = userRepository.findByEmail(setBonusRequestModel.getApplicant_email());
		if (Objects.isNull(user)) {
			throw new CustomException(204, " No Data Found of Specified Applicant Email");
		}
		if (user.isActive()){
			long difference = calculateDifferenceInDate.differenceCalculator(employeeReferal);
			Range<Integer> beginner = Range.between(0, 2);
			Range<Integer> senior = Range.between(3, 5);
			Range<Integer> superSenior = Range.between(6, 15);
			if(beginner.contains(employeeReferal.getExperience())) {
				return " No Bonus Applicant";
			}
			if(senior.contains(employeeReferal.getExperience())){
				long basic_amount = 10000;
				employeeReferal.setBonus_amount(getAmount(employeeReferal,difference,basic_amount));
				return " 1st stage Bonus Updated Successfully";
			}
			if(superSenior.contains(employeeReferal.getExperience())){
				long basic_amount = 15000;
				employeeReferal.setBonus_amount(getAmount(employeeReferal,difference,basic_amount));
				return " Total Bonus amount Updated";
			}
		
		}else{
			throw new CustomException(403, " User is inActive");
		}
		return "No Bonus";
	}

	private long getAmount(EmployeeReferal employeeReferal,long difference, long basic_amount) {
		long amount = 0;
		if(difference>=100){
			amount = basic_amount;
			employeeReferal.setBonus_amount(amount);
		}else if(difference>=45){
			amount = basic_amount/2;
			employeeReferal.setBonus_amount(amount);
		}
		return amount;
	}

}
