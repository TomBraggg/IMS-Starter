package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {
	
	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils;
	
	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	@Override
	public Order create() {
		LOGGER.info("Please enter a customer ID");
		Long customerId = utils.getLong();
		
//		show list of items
//		ask user to add items to order, create items
//		until user completes order
		
//		boolean incompleteOrder = true;
//		while(moreItems) {
//			LOGGER.info("Select item id or select 0 to create new item");
//			Long itemId = utils.getLong();
//			if (itemId.equals(0)) {
//				moreItems = false
//			}
//			LOGGER.info("Please select the quantity of your item");
//			Long itemQuantity = utils.getLong();
//		}
		
		Order order = orderDAO.create(new Order(customerId));
		LOGGER.info("Order created");
		return order;
	}

	@Override
	public Order update() {
		LOGGER.info("Please enter the order ID of the order you would like to update");
		Long orderId = utils.getLong();
		LOGGER.info("Please enter a new Customer ID to associate the order with");
		Long customerId = utils.getLong();
		Order order = orderDAO.update(new Order(orderId, customerId));
		LOGGER.info("Order updated");
		return order;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the order_id of the order you would like to delete");
		Long orderId = utils.getLong();
		return orderDAO.delete(orderId);
	}

}
