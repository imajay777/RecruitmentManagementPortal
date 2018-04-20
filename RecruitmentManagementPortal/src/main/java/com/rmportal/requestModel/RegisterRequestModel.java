package com.rmportal.requestModel;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.rmportal.model.Role;

import lombok.Data;

/**
 * @author tejas
 *
 */



@Data
public class RegisterRequestModel {
	
	int id;

	@NotEmpty
	String firstname;
	@NotEmpty
	String lastname;
	@NotEmpty
	String password;
	@Email
	String email;
	
	private boolean active;
	
}
