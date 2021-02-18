package com.qa.ims.persistence.domain;

public class Order {

	private Long order_id;
	private Long id;
	
	public Order(Long id) {
		this.setId(id);
	}
	
	public Order(Long order_id, Long id) {
		this.setOrder_id(order_id);
		this.setId(id);
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
