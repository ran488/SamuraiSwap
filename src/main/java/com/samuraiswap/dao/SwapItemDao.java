package com.samuraiswap.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import com.samuraiswap.dto.SwapItem;

/**
 * DAO interface for persisting and retrieving SwapItem objects.
 * 
 * @author ran488
 * 
 */
public class SwapItemDao implements GenericDao<SwapItem> {

	private static final Logger log = Logger.getLogger(SwapItemDao.class);

	/** name of collection in MongoDB database. */
	private static final String COLLECTION = "swap_items";

	private MongoClient mongoClient;
	private DBCollection swapItems;

	public SwapItemDao(DB db, Properties credentials) {
		log.info("Creating SwapItemDao...");
		boolean authenticated = db.authenticate(
				credentials.getProperty("username"),
				credentials.getProperty("password").toCharArray());
		log.debug(String.format("Authenticated to %s? %s", db.getName(),
				authenticated));

		if (!db.collectionExists(COLLECTION))
			db.createCollection(COLLECTION, null);
		swapItems = db.getCollection(COLLECTION);
		log.info("...Done creating SwapItemDao");
	}

	@Override
	public int insert(SwapItem newItem) {
		log.debug(String.format("Inserting: %s", newItem.toString()));
		WriteResult result = swapItems.insert(newItem.toDbObject());
		return result.getN();
	}

	@Override
	public int update(SwapItem criteria, SwapItem newValues) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(SwapItem oldItem) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SwapItem> findAll() {
		log.debug("Querying ALL: ");
		List<SwapItem> results = new ArrayList<>();
		DBCursor cursor = swapItems.find();
		while (cursor.hasNext()) {
			results.add(new SwapItem(cursor.next()));
		}
		return results;
	}

	@Override
	public List<SwapItem> findByExample(SwapItem criteria) {
		// TODO Auto-generated method stub
		return null;
	}
}
