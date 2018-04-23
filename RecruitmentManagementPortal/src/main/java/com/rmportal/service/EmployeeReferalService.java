package com.rmportal.service;

import com.rmportal.responseModel.EmployeeReferalResponseModel;
import com.rmportal.responseModel.UpdateResponseModel;
import com.rmportal.utility.CustomException;

public interface EmployeeReferalService {
	
	/*public EmployeeReferalResponseModel getEmployeeDetails(int referal_id) throws CustomException;*/
	
	public EmployeeReferalResponseModel getEmployeeDetails(String referance_email ) throws CustomException;

}
