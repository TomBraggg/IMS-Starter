package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
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

		ItemDAO itemDAO = new ItemDAO();
		ItemController itemController = new ItemController(itemDAO, utils);
		itemController.readAll();
		
		boolean incompleteOrder = true;
		Order order = new Order(customerId);
		
		while (incompleteOrder) {
			LOGGER.info("Type add to add an existing item, type create to create a new item or complete to complete your order");
			String orderPhase = utils.getString().toLowerCase();
//			ask user to add items to order including quantity, create items in hash map
			switch(orderPhase){
			case "create":
				itemController.create();
				break;
			case "add":
				LOGGER.info("Enter the item ID of the item you would like to add to your order");
				Integer orderItem = utils.getInt();
				LOGGER.info("How many of that item would you like to add to the order");
				int quantity = utils.getInt();
				order.addItem(orderItem, quantity);
				itemController.readAll();
				break;
			case "complete":
				incompleteOrder = false;
				break;
			default:
				LOGGER.info("Please enter one of the three options");
				break;
			}
		}		
		orderDAO.create(order);
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
