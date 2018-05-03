package com.rmportal.requestModel;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

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
	@Size(max=16, min=8, message="Length of password must be atleast 8-16 characters" )
	@NotEmpty
	String password;
	@Email
	String email;

}
