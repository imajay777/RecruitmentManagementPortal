package com.rmportal.requestModel;

/**
 * @author saurabh
 *
 */
public class LoginRequestModel {

	String name;
	String password;

	public LoginRequestModel() {

	}

	public LoginRequestModel(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginRequestModel [name=" + name + ", password=" + password + "]";
	}

}
