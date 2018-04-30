package com.rmportal.responseModel;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(includeFieldNames = true)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = false)
public class LoginResponseModel {

	int user_id;

	String firstName;

	String lastName;

	String email;

	boolean profileStatus;
	
	RoleResponseModel roleResponse;

	UserPremissionModel permissions;

	

	// Role roles;

}
