package com.rmportal.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rmportal.model.User;

/**
 * @author tejas
 *
 */

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Integer> {

	@Query(value = "SELECT * FROM user WHERE email =:email AND password=:password", nativeQuery = true)
	User findByEmail(@Param("email") String username, @Param("password") String password);

	@Query(value = "SELECT * FROM user WHERE email =:email", nativeQuery = true)
	User findByEmail(@Param("email") String email);
	
	@Query(value = "SELECT * FROM user WHERE user_id =:user_id", nativeQuery = true)
	User findByUserId(@Param("user_id") int userId);
	
	/*@Query(value="SELECT permission.permission_id,permission.permission_type, permission_role.role_id from permission inner join permission_role on permission.permission_id=permission_role.role_permission_id",nativeQuertrue)
	User findRoleAndPermission*/
}
