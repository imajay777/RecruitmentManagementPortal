package com.rmportal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author tejas
 *
 */

@Table(name = "role")
@Entity
@Data
@EqualsAndHashCode(exclude="user")

public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id")
	private int id;
	
	@Column(name = "role_name")
	private String role;
	
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY, mappedBy = "roles")
	@JsonBackReference
	List<User> user;
	
	/*@OneToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY, mappedBy = "user_id")
	@JsonBackReference
	String userId;*/
	
	@OneToMany 
	@JoinTable(name = "permission_role", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "permission_id"))
	@JsonManagedReference
	private List<Permission> rolePermission;
	

}
