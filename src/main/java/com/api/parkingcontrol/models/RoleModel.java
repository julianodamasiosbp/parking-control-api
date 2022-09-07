package com.api.parkingcontrol.models;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.api.parkingcontrol.enums.RoleName;

@Entity
@Table(name = "TB_ROLE")
public class RoleModel implements GrantedAuthority, Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID roleId;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, unique = true)
	private RoleName rolename;
	
	
	public UUID getRoleId() {
		return roleId;
	}


	public void setRoleId(UUID roleId) {
		this.roleId = roleId;
	}


	public RoleName getRolename() {
		return rolename;
	}


	public void setRolename(RoleName rolename) {
		this.rolename = rolename;
	}


	@Override
	public String getAuthority() {
		return this.rolename.toString();
	}

}
