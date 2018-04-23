package com.rmportal.responseModel;

import javax.persistence.Column;

import lombok.Data;


@Data
public class EmployeeReferalResponseModel 
{
	

	String applicant_name;
	
	
	String experience;
	

	String technical_skill;
	
//	@Column(name="referance_email")
//	String referance_email;

//	@Column(name="referance_user_id")
//	int referance_user_id;
//	

	byte[] resume;
	
	
	String application_status;
	

	int job_id;
	

	String bonous_status;
}
