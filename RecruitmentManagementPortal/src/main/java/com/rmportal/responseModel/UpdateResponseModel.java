package com.rmportal.responseModel;

import com.rmportal.model.Department;

import lombok.Data;

@Data
public class UpdateResponseModel {
	
	String employee_id;
	String firstName;
	String lastName;
	Department department;
	String address;
	String DOB;
	String city;
	String country;
	long mobile;
	String blood_group;
	String email;
//	Role role;
	String roles;
	//String dept_name;

	

}
