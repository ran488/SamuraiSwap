package com.samuraiswap.web;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.samuraiswap.dao.SwapItemDao;
import com.samuraiswap.dto.SwapItem;

/** An unholy mix of crap from the REST controller tutorials and my own code. TODO clean this up after I get it all working.
 * 
 * @author ranichol
 *
 */
@Controller
public class SwapMatcherController {

	private static final String template = "Hello, %s! (%s)";
	private final AtomicLong counter = new AtomicLong();

	/**
	 * DAO to access swap items data store.
	 * 
	 */
	private SwapItemDao dao;

	@Autowired
	public SwapMatcherController(SwapItemDao dao) {
		this.dao = dao;
	}

	@RequestMapping("hello")
	public @ResponseBody
	String greeting(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		return String.format(template, name, counter.incrementAndGet());
	}

	@RequestMapping("getSwapItems")
	public @ResponseBody
	String getSwapItems(
			@RequestParam(value = "criteria", required = false, defaultValue = "") String criteria) {
		List<SwapItem> items = dao.findAll();
		return items.toString();
	}

	/** hard-coded for now just to prove it works, which it does.
	 * 
	 * @return
	 */
	@RequestMapping(value = "createSwapItem", method = RequestMethod.POST)
	public @ResponseBody
	String createSwapItem() {
		SwapItem item = new SwapItem();
		item.setDescription("This is where it's at.");
		item.setOwner("rick");
		item.setSummary("Shiver Me Timbers");
		item.setLocation("KS");
		item.setPostedOn(new Date());
		item.setExpiresAfter(new Date(System.currentTimeMillis() + 600000L));
		dao.insert(item);
		return item.toDbObject().toString();
	}
}