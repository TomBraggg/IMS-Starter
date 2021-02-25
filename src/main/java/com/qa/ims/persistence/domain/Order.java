package com.qa.ims.persistence.domain;

import java.sql.Date;
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
		this.orderDate = Date.valueOf(java.time.LocalDate.now());
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((orderLineQuantities == null) ? 0 : orderLineQuantities.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (orderLineQuantities == null) {
			if (other.orderLineQuantities != null)
				return false;
		} else if (!orderLineQuantities.equals(other.orderLineQuantities))
			return false;
		return true;
	}
	
	
	
}
