package com.rmportal.service;

import com.rmportal.requestModel.LoginRequestModel;
import com.rmportal.responseModel.ResponseModel;
import com.rmportal.utility.CustomException;

/**
 * @author saurabh
 *
 */
public interface LoginServices {

	public ResponseModel validateUser(LoginRequestModel loginRequestModel) throws CustomException;

}
