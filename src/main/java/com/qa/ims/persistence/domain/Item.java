package com.qa.ims.persistence.domain;

public class Item {

	private Long itemId;
	private String itemName;
	private Double itemValue;
	
	public Item(Long itemId, String itemName, Double itemValue) {
		this.setItemId(itemId);
		this.setItemName(itemName);
		this.setItemValue(itemValue);
	}
	
	public Item(String itemName, Double itemValue) {
		this.setItemName(itemName);
		this.setItemValue(itemValue);
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
	public Double getItemValue() {
		return itemValue;
	}
	public void setItemValue(Double itemValue) {
		this.itemValue = itemValue;
	}
	
	public String toString() {
		return "item_id:" + itemId + " item_name:" + itemName + " item_value:" + itemValue;
	}
	
}
