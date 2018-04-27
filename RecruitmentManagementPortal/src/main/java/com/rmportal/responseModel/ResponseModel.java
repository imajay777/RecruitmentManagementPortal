package com.rmportal.responseModel;

import com.rmportal.model.Role;

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
public class ResponseModel {

	int user_id;

	String firstName;

	String lastName;

	String email;

	Role role;

	UserPremissionModel permissions;

	// Role roles;

}
