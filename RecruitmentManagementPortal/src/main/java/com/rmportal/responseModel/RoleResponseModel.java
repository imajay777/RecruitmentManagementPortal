package com.rmportal.responseModel;

import java.util.List;

import com.rmportal.model.Permission;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author saurabh
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleResponseModel {

	int id;
	
	String role;
	
	List<Permission> permissions;
	
}
