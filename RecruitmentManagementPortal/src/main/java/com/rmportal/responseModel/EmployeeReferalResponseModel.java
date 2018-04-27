package com.rmportal.responseModel;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeReferalResponseModel {

	int referal_id;

	String applicant_name;

	int experience;

	String technical_skill;

	// @Column(name="referance_email")
	// String referance_email;

	// @Column(name="referance_user_id")
	// int referance_user_id;
	//

	String resume;

	String application_status;

	int job_id;

	Date date;
	
	String bonous_status;
}
