package com.hcl.ing.hungerbox.dto;

import java.io.Serializable;
import java.util.List;

import com.hcl.ing.hungerbox.entity.Vendors;

public class VendorResponseDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private String message;
	private Integer statusCode;
	private List<Vendors> vendors;
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
	public List<Vendors> getVendors() {
		return vendors;
	}
	public void setVendors(List<Vendors> vendors) {
		this.vendors = vendors;
	}
	
}
