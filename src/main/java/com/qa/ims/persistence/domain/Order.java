package com.qa.ims.persistence.domain;

import java.util.Date;
import java.util.Map;

public class Order {

	private Long orderId;
	private Long customerId;
	private Date orderDate;
	private Map<Item, Integer> orderLineQuantities;
	
	
	public Order(Long id) {
		this.setId(id);
		this.setOrderDate();
	}
	
	public Order(Long order_id, Long id) {
		this.setOrderId(order_id);
		this.setId(id);
		this.setOrderDate();
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getId() {
		return customerId;
	}

	public void setId(Long id) {
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
	
	public Map<Item, Integer> getOrderLineQuantities() {
		return orderLineQuantities;
	}

	public void addItem(Item item, int quantity) {
		this.orderLineQuantities.put(item, quantity);
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "order_id:" + orderId + " id" + customerId + " date:" + orderDate;
=======
		return "order_id:" + orderId + " id:" + id + " date:" + orderDate;
>>>>>>> dev
	}
	
}
