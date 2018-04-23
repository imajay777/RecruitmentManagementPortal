package com.rmportal.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmportal.model.EmployeeReferal;
import com.rmportal.repository.EmployeeReferalRepository;
import com.rmportal.responseModel.EmployeeReferalResponseModel;
import com.rmportal.utility.ConversionUtility;
import com.rmportal.utility.CustomException;

/**
 * @author tejas
 *
 */
@Service
public class EmployeeReferalServiceImpl implements EmployeeReferalService{
	
	@Autowired
	EmployeeReferalRepository employeeReferalRepository;
	
	@Autowired
	ConversionUtility conversionUtility;
	
	
	/*@Override
	public EmployeeReferalResponseModel getEmployeeDetails(int referal_id ) throws CustomException {
		EmployeeReferal employeeReferal=employeeReferalRepository.findByEmployeeId(referal_id);
		
		if (Objects.isNull(employeeReferal)) {
			throw new CustomException(500, " Unable to fetch Details");
		}
		return conversionUtility.convertTOGetEmployees(employeeReferal);
	}
*/

	@Override
	public EmployeeReferalResponseModel getEmployeeDetails(String referance_email) throws CustomException {
		EmployeeReferal employeeReferal=employeeReferalRepository.findByEmployeeEmail(referance_email);
		
		if (Objects.isNull(employeeReferal)) {
			throw new CustomException(500, " Unable to fetch Details");
		}
		return conversionUtility.convertTOGetEmployees(employeeReferal);
	}
	

	

}
