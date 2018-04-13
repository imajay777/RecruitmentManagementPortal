package com.rmportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmportal.constants.Constants;
import com.rmportal.repo.EmployeeRepo;
import com.rmportal.repository.Employee;
import com.rmportal.requestModel.LoginRequestModel;
import com.rmportal.responseModel.LoginResponseModel;

/**
 * @author saurabh
 *
 */

@Service
public class LoginServiceImpl implements LoginServices {
	
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	
	@Override
	public LoginResponseModel validateUser(LoginRequestModel login) {
		LoginResponseModel apiResponse = new LoginResponseModel();
		Employee employeeFromTable = employeeRepo.findByName(login.getName());

		if (null != employeeFromTable) {
			apiResponse.setMessage(Constants.OK.getStatus());
			apiResponse.setResponse(login);
			apiResponse.setStatus(Constants.OK.id);
			return apiResponse;
			
		} else {
			apiResponse.setMessage("Username or Password is Invalid!!!");
			return apiResponse;
		}
		
		
	}


	
}
