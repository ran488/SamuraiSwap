package com.samuraiswap.dto;

import java.io.Serializable;
import java.util.Date;

import org.apache.log4j.Logger;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * VO that Represents an item that can be swapped for another.
 * 
 * @author ran488
 * 
 */
public class SwapItem implements Serializable {

	private static final Logger log = Logger.getLogger(SwapItem.class);

	private static final long serialVersionUID = -8947081363496617761L;

	/** name of field in the data store */
	protected static final String EXPIRATION_DATE_FIELD_NAME = "expirationDate";
	/** name of field in the data store */
	protected static final String POSTED_DATE_FIELD_NAME = "postedDate";
	/** name of field in the data store */
	protected static final String OWNER_FIELD_NAME = "owner";
	/** name of field in the data store */
	protected static final String LOCATION_FIELD_NAME = "location";
	/** name of field in the data store */
	protected static final String SUMMARY_FIELD_NAME = "summary";
	/** name of field in the data store */
	protected static final String DESCRIPTION_FIELD_NAME = "description";

	/** who posted this item for swap? */
	private String owner;
	/** date the item was posted for swap */
	private Date postedOn;
	/** date the item expires, if ever */
	private Date expiresAfter;
	/** location (city/state/?) */
	private String location;
	/** summary/title line of the item */
	private String summary;
	/** more detailed description of the item */
	private String description;

	/**
	 * No-arg constructor.
	 */
	public SwapItem() {
		super();
	}

	/**
	 * Take a DB Object and create a VO from it.
	 * 
	 * @return
	 */
	public SwapItem(DBObject dbo) {
		assert dbo instanceof BasicDBObject;
		BasicDBObject dbObject = (BasicDBObject) dbo;
		this.owner = dbObject.getString(OWNER_FIELD_NAME);
		this.postedOn = dbObject.getDate(POSTED_DATE_FIELD_NAME);
		this.expiresAfter = dbObject.getDate(EXPIRATION_DATE_FIELD_NAME);
		this.location = dbObject.getString(LOCATION_FIELD_NAME);
		this.summary = dbObject.getString(SUMMARY_FIELD_NAME);
		this.description = dbObject.getString(DESCRIPTION_FIELD_NAME);
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Date getPostedOn() {
		return (postedOn != null) ? (Date) postedOn.clone() : null;
	}

	public void setPostedOn(final Date postedOn) {
		this.postedOn = (Date) postedOn.clone();
	}

	public Date getExpiresAfter() {
		return (expiresAfter != null) ? (Date) expiresAfter.clone() : null;
	}

	public void setExpiresAfter(final Date expiresAfter) {
		this.expiresAfter = (Date) expiresAfter.clone();
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		/*
		 * return String .format(
		 * "SwapItem [owner=%s, postedOn=%s, expiresAfter=%s, location=%s, summary=%s, description=%s]"
		 * , owner, postedOn, expiresAfter, location, summary, description);
		 */
		return this.toDbObject().toString();
	}

	/**
	 * Util method to convert between MongoDB DBObject and system VO.
	 * 
	 * @param o
	 * @return
	 */
	public BasicDBObject toDbObject() {
		BasicDBObject o = new BasicDBObject();
		if (this.getSummary() != null)
			o.append(SUMMARY_FIELD_NAME, this.getSummary());
		if (this.getDescription() != null)
			o.append(DESCRIPTION_FIELD_NAME, this.getDescription());
		if (this.getLocation() != null)
			o.append(LOCATION_FIELD_NAME, this.getLocation());
		if (this.getOwner() != null)
			o.append(OWNER_FIELD_NAME, this.getOwner());
		if (this.getPostedOn() != null)
			o.append(POSTED_DATE_FIELD_NAME, this.getPostedOn());
		if (this.getExpiresAfter() != null)
			o.append(EXPIRATION_DATE_FIELD_NAME, this.getExpiresAfter());
		log.debug(String.format("New DBObject: %s", o));
		return o;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((expiresAfter == null) ? 0 : expiresAfter.hashCode());
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result
				+ ((postedOn == null) ? 0 : postedOn.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SwapItem other = (SwapItem) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (expiresAfter == null) {
			if (other.expiresAfter != null)
				return false;
		} else if (!expiresAfter.equals(other.expiresAfter))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (postedOn == null) {
			if (other.postedOn != null)
				return false;
		} else if (!postedOn.equals(other.postedOn))
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		return true;
	}

}
