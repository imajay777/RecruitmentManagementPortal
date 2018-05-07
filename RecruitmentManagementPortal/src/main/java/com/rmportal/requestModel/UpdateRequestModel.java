package com.rmportal.requestModel;

import javax.validation.constraints.Size;

import com.rmportal.model.Department;

import lombok.Data;

@Data
public class UpdateRequestModel {

//	String employee_id;
//	String userName;
	String firstName;
	String lastName;
//	String email;
	String address;
	String dateOfBirth;
	String city;
	String country;
	String employee_id;
	@Size(max=10, message="Mobile Number cannot be greater than 10 digits.")
	String mobile;
	String blood_group;
	//String dept_name;
	
	
//	Department department;

	String dept_name;
}
