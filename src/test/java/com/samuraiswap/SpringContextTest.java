package com.samuraiswap;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.samuraiswap.dao.SwapItemDao;
import com.samuraiswap.dto.SwapItem;

@Ignore
public class SpringContextTest {

	private static final Logger log = Logger.getLogger(SpringContextTest.class);
	
	protected ApplicationContext ac;

	@Before
	public void setUp() throws Exception {
		System.setProperty("OPENSHIFT_MONGODB_DB_HOST", "localhost");
		System.setProperty("OPENSHIFT_MONGODB_DB_PORT", "27017");
		System.setProperty("OPENSHIFT_MONGODB_DB_USERNAME", "Dude");
		System.setProperty("OPENSHIFT_MONGODB_DB_PASSWORD", "passW0rD");

		String[] envVars = System.getenv().toString().split(",");
		for (String var : envVars) {
			log.debug(var);
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Just make sure I can load up the Spring ApplicationContext.xml without
	 * anything blowing chunks.
	 * 
	 */
	@Test
	public void testApplicationContext_CanBeLoaded() {
		ac = new FileSystemXmlApplicationContext(
				new File("src/main/webapp/WEB-INF/ApplicationContext.xml")
						.getAbsolutePath());
		
		SwapItemDao dao = ac.getBean("swapItemDao", SwapItemDao.class);

		assertNotNull(dao);
		
		SwapItem vo = new SwapItem();
		vo.setExpiresAfter(new Date());
		vo.setPostedOn(new Date());
		vo.setDescription("A bunch of poo. That's right, it is POO. SMELL IT!~!");
		vo.setSummary("Crap");
		vo.setOwner("MEEEEeeeeeee");
		vo.setLocation("N/A");
		dao.insert(vo);
		List<SwapItem> items = dao.findAll();
		for (SwapItem item : items) {
			log.debug(item.toString());
		}

	}

}
