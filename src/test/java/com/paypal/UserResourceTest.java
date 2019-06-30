package com.paypal;

import java.util.Date;

import com.paypal.assignment3.persistence.PersistenceManagerFactory;
import com.paypal.assignment3.resources.ResourceNotFoundException;
import com.paypal.assignment3.resources.UnaleToCreateNewResource;
import com.paypal.assignment3.resources.User;
import com.paypal.assignment3.resources.UserResource;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserResourceTest {

	@Test
	public void testSave() throws UnaleToCreateNewResource, ResourceNotFoundException {
		UserResource userResource = new UserResource(PersistenceManagerFactory.getInstance().createPersistanceManager(PersistenceManagerFactory.PersistanceType.IN_MEMORY));
		User user = new User();
		user.setAsset("asset");
		user.setLoginTime(String.valueOf(new Date()));
		user.addIpAddress("127.0.0.1");
		String key = userResource.create(user);
		assertTrue ( "key was found null",key != null);
		User attachedUser = userResource.getUser(key);
		assertTrue("fetched user found null", attachedUser != null );
		attachedUser.addIpAddress("100.100.100.100");
		attachedUser = userResource.update(key, attachedUser);
		assertTrue( "new Ip addres updated" ,attachedUser.getLoggedIpAddresses().contains("100.100.100.100"));
		assertTrue(  "anomaly detected", userResource.detectAnomaly(key, "100.100.100.100"));
		assertTrue(  "anomaly detected", userResource.detectAnomaly(key, "127.0.0.1"));
		assertFalse (  "anomaly detected", userResource.detectAnomaly(key, "120.100.100.100"));
	}
}
