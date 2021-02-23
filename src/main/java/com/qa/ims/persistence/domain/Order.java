package com.qa.ims.persistence.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Order {

	private Long orderId;
	private Long customerId;
	private Date orderDate;
	private Map<Integer, Integer> orderLineQuantities = new HashMap<>();
	
	
	public Order(Long customerId) {
		this.setCustomerId(customerId);
		this.setOrderDate();
	}
	
	public Order(Long order_id, Long id) {
		this.setOrderId(order_id);
		this.setCustomerId(id);
		this.setOrderDate();
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long id) {
		this.customerId = id;
	}
	
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	public void setOrderDate() {
		this.orderDate = java.sql.Date.valueOf(java.time.LocalDate.now());
	}

	public Date getOrderDate() {
		return orderDate;
	}
	
	public Map<Integer, Integer> getOrderLineQuantities() {
		return orderLineQuantities;
	}

	public void addItem(Integer orderItem, int quantity) {
		this.orderLineQuantities.put(orderItem, quantity);
	} 

	@Override
	public String toString() {

		return "order_id:" + orderId + " id" + customerId + " date:" + orderDate;

	}
	
}
