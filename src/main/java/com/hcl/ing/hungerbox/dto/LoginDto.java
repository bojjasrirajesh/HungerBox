package com.hcl.ing.hungerbox.dto;

import java.io.Serializable;

public class LoginDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private String uName;
	private String password;
	private String roleName;
	
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}