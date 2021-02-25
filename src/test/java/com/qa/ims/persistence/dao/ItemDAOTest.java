package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTest {

	private final ItemDAO ItemDAO = new ItemDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Item created = new Item(2L, "testItem", 1.99);
		assertEquals(created, ItemDAO.create(created));
	}
	
	@Test
	public void testCreateException() {
		final Item created = new Item(null, "testItem", 1.99);
		assertNotEquals(created, ItemDAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Item> expected = new ArrayList<>();
		expected.add(new Item(1L, "testItem", 1.99));
		assertEquals(expected, ItemDAO.readAll());
	}
	
	@Test
	public void testReadAllException() {
		List<Item> expected = new ArrayList<>();
		expected.add(new Item(null, "testItem", 1.99));
		assertNotEquals(expected, ItemDAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Item(1L, "testItem", 1.99), ItemDAO.readLatest());
	}
	
	@Test
	public void testReadLatestException() {
		assertNotEquals(new Item(null, "testItem", 1.99), ItemDAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Item(ID, "testItem", 1.99), ItemDAO.read(ID));
	}
	
	@Test
	public void testReadException() {
		final long ID = 1L;
		assertNotEquals(new Item(null, "testItem", 1.99), ItemDAO.read(ID));
	}

	@Test
	public void testUpdate() {
		final Item updated = new Item(1L, "testItem", 1.99);
		assertEquals(updated, ItemDAO.update(updated));

	}
	
	@Test
	public void testUpdateException() {
		final Item updated = new Item(null, "testItem", 1.99);
		assertNotEquals(updated, ItemDAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1, ItemDAO.delete(1));
	}
}
