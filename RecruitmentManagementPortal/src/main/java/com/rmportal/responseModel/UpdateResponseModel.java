package com.rmportal.responseModel;

import com.rmportal.model.Department;
import com.rmportal.model.Role;

import lombok.Data;

@Data
public class UpdateResponseModel {
	
	String employee_id;
	String first_name;
	String last_name;
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

	

}
