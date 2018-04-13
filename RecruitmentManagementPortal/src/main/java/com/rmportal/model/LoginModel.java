package com.rmportal.model;

import org.springframework.stereotype.Component;

/**
 * @author saurabh
 *
 */

@Component
public class LoginModel {

	private String username;
	private String password;
	private int isActive;


	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
