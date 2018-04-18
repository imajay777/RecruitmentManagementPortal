package com.rmportal.requestModel;

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
public class ChangePasswordModel {

	
	String email;
	
	String oldPassword;
	
	String newPassword;
	
}
