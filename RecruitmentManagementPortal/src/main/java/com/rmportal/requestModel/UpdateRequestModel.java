package com.rmportal.requestModel;

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
	long mobile;
	String blood_group;
	//String dept_name;
	Department department;

}
