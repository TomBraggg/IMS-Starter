package com.qa.ims.persistence.domain;

import java.util.Date;

public class Order {

	private Long orderId;
	private Long id;
	static private Date orderDate = java.sql.Date.valueOf(java.time.LocalDate.now());
	
	public Order(Long id) {
		this.setId(id);
	}
	
	public Order(Long order_id, Long id) {
		this.setOrder_id(order_id);
		this.setId(id);
	}

	public Long getOrder_id() {
		return orderId;
	}

	public void setOrder_id(Long orderId) {
		this.orderId = orderId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}
	
	@Override
	public String toString() {
		return "order_id:" + orderId + " id" + id + " date:" + orderDate;
	}
	
}
