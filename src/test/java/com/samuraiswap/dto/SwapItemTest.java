package com.samuraiswap.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mongodb.BasicDBObject;

public class SwapItemTest {

	private static final Logger log = Logger.getLogger(SwapItemTest.class);

	private static final String LOCATION = "NY";
	private static final String OWNER = "ran488";
	private static final String THE_SUMMARY_LINE = "the summary line";
	private static final String THE_DETAILED_DESCRIPTION = "the detailed description";
	private static final Date RIGHT_NOW;
	private static final Date LATER;

	// class under test
	SwapItem item;

	@Before
	public void setUp() throws Exception {
		item = new SwapItem();
	}

	@After
	public void tearDown() throws Exception {
		item = null;
	}

	@Test
	public void testVoToDbObject_AllValuesPopulated() {
		populateSwapItemVO();

		BasicDBObject dbObject = item.toDbObject();

		assertTrue(dbObject.containsField(SwapItem.SUMMARY_FIELD_NAME));
		assertTrue(dbObject.containsField(SwapItem.DESCRIPTION_FIELD_NAME));
		assertTrue(dbObject.containsField(SwapItem.LOCATION_FIELD_NAME));
		assertTrue(dbObject.containsField(SwapItem.OWNER_FIELD_NAME));
		assertTrue(dbObject.containsField(SwapItem.POSTED_DATE_FIELD_NAME));
		assertTrue(dbObject.containsField(SwapItem.EXPIRATION_DATE_FIELD_NAME));

		assertTrue(dbObject.containsValue(LATER));
		assertTrue(dbObject.containsValue(THE_SUMMARY_LINE));
		assertTrue(dbObject.containsValue(OWNER));
		assertTrue(dbObject.containsValue(LOCATION));
	}

	private void populateSwapItemVO() {
		item.setDescription(THE_DETAILED_DESCRIPTION);
		item.setSummary(THE_SUMMARY_LINE);
		item.setPostedOn(RIGHT_NOW);
		item.setExpiresAfter(LATER);
		item.setOwner(OWNER);
		item.setLocation(LOCATION);
	}

	@Test
	public void testVoToDbObject_NoValuesShouldNotBlowUp() {
		BasicDBObject dbObject = item.toDbObject();
		assertFalse(dbObject.containsField(SwapItem.SUMMARY_FIELD_NAME));
		assertFalse(dbObject.containsField(SwapItem.DESCRIPTION_FIELD_NAME));
		assertFalse(dbObject.containsField(SwapItem.LOCATION_FIELD_NAME));
		assertFalse(dbObject.containsField(SwapItem.OWNER_FIELD_NAME));
		assertFalse(dbObject.containsField(SwapItem.POSTED_DATE_FIELD_NAME));
		assertFalse(dbObject.containsField(SwapItem.EXPIRATION_DATE_FIELD_NAME));
	}

	@Test
	public void testDbObjectConstructor() {
		populateSwapItemVO();
		BasicDBObject dbObject = item.toDbObject();
		SwapItem newSwapItem = new SwapItem(dbObject);
		assertEquals(item, newSwapItem);

	}

	static {
		Calendar calendar = Calendar.getInstance();
		// current date/time
		RIGHT_NOW = calendar.getTime();
		// 2 months into the future
		calendar.roll(Calendar.MONTH, 2);
		LATER = calendar.getTime();
	}
}
