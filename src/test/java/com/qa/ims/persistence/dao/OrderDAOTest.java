package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {

	private final OrderDAO OrderDAO = new OrderDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Order created = new Order(2L, 1L);
		assertEquals(created, OrderDAO.create(created));
	}
	
	@Test
	public void testCreateException() {
		final Order created = new Order(null, null);
		assertNotEquals(created, OrderDAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Order> expected = new ArrayList<>();
		expected.add(new Order(1L, 1L));
		assertEquals(expected, OrderDAO.readAll());
	}
	
	@Test
	public void testReadAllException() {
		List<Order> expected = new ArrayList<>();
		expected.add(new Order(null, null));
		assertNotEquals(expected, OrderDAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Order(1L, 1L), OrderDAO.readLatest());
	}
	
	@Test
	public void testReadLatestException() {
		assertNotEquals(new Order(null, null), OrderDAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		final long OrderID = 1L;
		assertEquals(new Order(OrderID, ID), OrderDAO.read(ID));
	}
	
	@Test
	public void testReadException() {
		final long ID = 1L;
		assertNotEquals(new Order(null, null), OrderDAO.read(ID));
	}

	@Test
	public void testUpdate() {
		final Order updated = new Order(1L, 1L);
		
		System.out.println(updated.toString());

		assertEquals(updated, OrderDAO.update(updated));
	}
	
	@Test
	public void testUpdateException() {
		final Order updated = new Order(null, null);
		
		System.out.println(updated.toString());

		assertNotEquals(updated, OrderDAO.update(updated));
	}

	@Test
	public void testDelete() {
		assertEquals(1, OrderDAO.delete(1));
	}
	
	@Test
	public void testDeleteException() {
		assertNotEquals(null, OrderDAO.delete(1));
	}

}


