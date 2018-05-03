package com.rmportal.requestModel;

import javax.validation.constraints.NotNull;

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

	@NotNull(message = "Mandatory field cannot be Empty")
	String email;
	
	@NotNull(message = "Mandatory field cannot be Empty")
	String oldPassword;
	
	@NotNull(message = "Mandatory field cannot be Empty")
	String newPassword;
	
}
