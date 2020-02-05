package com.hcl.ing.hungerbox.dto;

import java.util.List;

public class ViewOrderResponseDTO {
	private List<ItemDTO> itemLists;
	private String orderDate;
	private Long OrderId;
	private Double totalPrice;
	private String status;
	public List<ItemDTO> getItemLists() {
		return itemLists;
	}
	public void setItemLists(List<ItemDTO> itemLists) {
		this.itemLists = itemLists;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public Long getOrderId() {
		return OrderId;
	}
	public void setOrderId(Long orderId) {
		OrderId = orderId;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
