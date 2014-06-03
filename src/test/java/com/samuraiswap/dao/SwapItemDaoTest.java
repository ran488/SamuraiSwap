package com.samuraiswap.dao;

import static org.junit.Assert.fail;

import java.util.Properties;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.mongodb.DB;

@Ignore
public class SwapItemDaoTest {

	// class under test
	SwapItemDao dao;

	// collaborators
	DB db;
	
	@Before
	public void setUp() throws Exception {
		db = EasyMock.createMock(DB.class);
		Properties creds = new Properties();
		creds.setProperty("username", "");
		creds.setProperty("password", "");
//		EasyMock.expect(db.collectionExists("swap_items")).andReturn(true);
//		EasyMock.expect(db.getCollection("swap_items")).andReturn(null);
//		EasyMock.replay(db);
		dao = new SwapItemDao(db, creds);
	}

	@After
	public void tearDown() throws Exception {
		dao = null;
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByExample() {
		fail("Not yet implemented");
	}



}
