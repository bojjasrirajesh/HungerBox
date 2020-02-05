package com.hcl.ing.hungerbox.dto;

import java.io.Serializable;

public class VendorRequestDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long vendorId;
	private String vendorName;
	private Long userId;
	public Long getVendorId() {
		return vendorId;
	}
	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	

}
