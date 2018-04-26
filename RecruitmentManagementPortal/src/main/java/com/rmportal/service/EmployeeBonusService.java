package com.rmportal.service;

import org.springframework.stereotype.Component;

import com.rmportal.responseModel.EmployeeBonusStatusResponseModel;
import com.rmportal.utility.CustomException;

@Component
public interface EmployeeBonusService {

	public EmployeeBonusStatusResponseModel getReferralBonus(int referal_id) throws CustomException;
	
}
