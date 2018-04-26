package com.rmportal.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name="permission")
@Data
@ToString
@EqualsAndHashCode(exclude="roles")
public class Permission {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="permission_id")
private int permission_id;

@Column(name="permission_name")
private String premissionName;

@ManyToMany(mappedBy = "rolePermission") 
@JsonBackReference
private List<Role> roles;


}
