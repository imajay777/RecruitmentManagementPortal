package com.rmportal.requestModel;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author saurabh
 *
 */
public class LoginRequestModel {

	@NotEmpty
	@Email
	String email;

	@NotEmpty
	String password;

	public LoginRequestModel() {
	}

	public LoginRequestModel(String password, String email) {
		super();
		this.password = password;
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "LoginRequestModel [password=" + password + ", email=" + email + "]";
	}

}
