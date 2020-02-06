package com.hcl.ing.hungerbox.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Vendors {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	@Override
	public String toString() {
		return "Vendors [vendorId=" + vendorId + ", vendorName=" + vendorName + ", userId=" + userId + "]";
	}
	public Vendors(Long vendorId, String vendorName, Long userId) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.userId = userId;
	}
	public Vendors() {
		super();
	}
	
	
	
	
	
	

}
