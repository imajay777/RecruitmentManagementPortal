package com.rmportal.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rmportal.model.UserToken;
import com.rmportal.utility.CustomException;

/**
 * @author saurabh
 *
 */
@Repository
public interface UserTokenRepository extends CrudRepository<UserToken, Integer>{
	
	 
	 @Query(value = "SELECT * FROM user_token WHERE user_id =:userId AND user_token=:token", nativeQuery = true)
	 UserToken findByToken(@Param("userId") int userId,@Param("token")String token) throws CustomException;
}
