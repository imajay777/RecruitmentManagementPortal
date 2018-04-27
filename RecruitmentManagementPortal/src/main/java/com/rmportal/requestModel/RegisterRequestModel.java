package com.rmportal.requestModel;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.rmportal.model.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tejas
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestModel {

	@NotEmpty
	String firstName;
	@NotEmpty
	String lastName;
	@NotEmpty
	String password;
	@Email
	String email;

}
