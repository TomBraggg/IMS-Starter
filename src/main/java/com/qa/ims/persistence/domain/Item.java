package com.qa.ims.persistence.domain;

public class Item {

	private Long itemId;
	private Long orderId;
	private String itemName;
	private Float itemValue;
	
	public Item(Long itemId, Long orderId, String itemName, Float itemValue) {
		this.setItemId(itemId);
		this.setOrderId(orderId);
		this.setItemName(itemName);
		this.setItemValue(itemValue);
	}
	
	public Item(Long orderId, String itemName, Float itemValue) {
		this.setOrderId(orderId);
		this.setItemName(itemName);
		this.setItemValue(itemValue);
	}
	
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Float getItemValue() {
		return itemValue;
	}
	public void setItemValue(Float itemValue) {
		this.itemValue = itemValue;
	}
	
	
	
}
