package com.rmportal.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rmportal.model.Role;
import com.rmportal.model.User;
import com.rmportal.repository.RoleRepository;
import com.rmportal.repository.UserRepository;
import com.rmportal.responseModel.RoleResponseModel;
import com.rmportal.utility.ConversionUtility;
import com.rmportal.utility.CustomException;

/**
 * @author saurabh
 *
 */
@Service
@Transactional
public class UpdateRolesImpl implements UpdateRoles {

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	ConversionUtility conversionUtility;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<RoleResponseModel> getAllRoles() throws CustomException {
		
		List<Role> roles = (List<Role>) roleRepository.findAll();
		return conversionUtility.convertToRoleResponseModel(roles);

	}

	@Override
	public List<String> getAllRoleTypes() throws CustomException {
		List<Role> roles = (List<Role>) roleRepository.findAll();
		return roles.stream().map(i -> i.getRole()).collect(Collectors.toList());
	}

	@Override
	public String changeRole(String email, int role_id) throws CustomException {

		Role roles = new Role();
		User user = userRepository.findByEmail(email);
		if(Objects.isNull(user)){
			throw new CustomException(203, "User Not found");
		}
		
		user.setRoles(roles);
		return "Role Updated Successfully";
	}

}
