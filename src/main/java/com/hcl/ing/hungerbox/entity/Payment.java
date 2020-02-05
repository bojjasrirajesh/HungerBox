package com.hcl.ing.hungerbox.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long paymentId;
	
	private String paymentType;
	private Long orderId;
	public Long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentType=" + paymentType + ", orderId=" + orderId + "]";
	}
	public Payment(Long paymentId, String paymentType, Long orderId) {
		super();
		this.paymentId = paymentId;
		this.paymentType = paymentType;
		this.orderId = orderId;
	}
	public Payment() {
		super();
	}
	
	

}


