package com.hcl.ing.hungerbox.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Items {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long itemId;
	private String itemName;
	private String itemType;
	private Double price;
	private Integer quantity;
	private Long userId;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Items [itemId=" + itemId + ", itemName=" + itemName + ", itemType=" + itemType + ", price=" + price
				+ ", quantity=" + quantity + ", vendorId="  + ", userId=" + userId + "]";
	}
	public Items() {
		super();
	}
	public Items(Long itemId, String itemName, String itemType, Double price, Integer quantity, Long vendorId,
			Long userId) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemType = itemType;
		this.price = price;
		this.quantity = quantity;
		this.userId = userId;
	}
	
	
	
	
	

}
