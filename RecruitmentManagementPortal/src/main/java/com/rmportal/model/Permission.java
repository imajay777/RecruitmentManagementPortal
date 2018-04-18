package com.rmportal.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="permission")
@Data
public class Permission {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="permission_id")
private int permission_id;

@Column(name="permission_name")
private String premissionName;

@ManyToMany(mappedBy = "rolePermission") 
private List<Role> roles;


}
