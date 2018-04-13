package com.rmportal.utility;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rmportal.model.LoginModel;


/**
 * @author saurabh
 *
 */
public class Mapper implements RowMapper<LoginModel>{
	@Override
	public LoginModel mapRow(ResultSet rs, int rowNum) throws SQLException {

		LoginModel login = new LoginModel();
		login.setUsername(rs.getString("name"));
		login.setUsername(rs.getString("username"));
		login.setPassword(rs.getString("password"));
		return login;
	}
}
