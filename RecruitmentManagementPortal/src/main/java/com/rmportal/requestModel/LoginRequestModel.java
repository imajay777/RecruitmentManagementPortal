package com.rmportal.requestModel;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author saurabh
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginRequestModel {

	

	@NotEmpty
	@Email
	String email;

	@NotEmpty
	String password;

	
}
