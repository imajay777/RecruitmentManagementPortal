package com.rmportal.responseModel;

import org.springframework.stereotype.Component;

/**
 * @author saurabh
 *
 */
@Component
public class LoginResponseModel {

	String message;
	int status;
	Object response;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

}
