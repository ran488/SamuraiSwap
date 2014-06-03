package com.samuraiswap.dao;

import java.util.List;

public interface GenericDao<T> {

	/**
	 * Insert a new record of type T.
	 * 
	 * @param newItem
	 * @return number of records successfully inserted.
	 */
	int insert(T newItem);

	/**
	 * Update reords that match criteria with the newValues.
	 * 
	 * @param criteria
	 * @param newValues
	 * @return number of records successfully updated.
	 */
	int update(T criteria, T newValues);

	/**
	 * Delete an item from underlying data store.
	 * 
	 * @param oldItem
	 * @return number of records deleted successfully.
	 */
	int delete(T oldItem);

	/**
	 * Find all records of type T.
	 * 
	 * @return List of all records.
	 */
	List<T> findAll();

	/**
	 * Fidn all records of type T that match search criteria.
	 * 
	 * @param criteria
	 * @return List of all matching records.
	 */
	List<T> findByExample(T criteria);

}
