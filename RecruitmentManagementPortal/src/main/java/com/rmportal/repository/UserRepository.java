package com.rmportal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rmportal.model.User;
import com.rmportal.requestModel.RegisterRequestModel;
import com.rmportal.responseModel.RegisterResponseModel;

/**
 * @author tejas
 *
 */

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Integer> {

	User findByEmail(String email);

	RegisterResponseModel save(RegisterRequestModel registerRequestModel);
}
