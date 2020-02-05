package com.hcl.ing.hungerbox.dto;

import java.io.Serializable;

public class LoginResponseDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private String message;
	private Integer statusCode;
	private Long userId;
	private String roleName;
	

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}


}
