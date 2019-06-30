package com.paypal;

import com.paypal.assignment3.persistence.InMemoryPersistenceManagerImpl;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class InMemoryPersistenceManagerTest {
	@Test
	public void testSave() {
		InMemoryPersistenceManagerImpl<String, String> impl = new InMemoryPersistenceManagerImpl<>();
		impl.save("key", "value");
		String value = impl.fetch("key");
		assertTrue( "value".equals(value));
	}

	@Test
	public void testCreate() {
		InMemoryPersistenceManagerImpl<String, String> impl = new InMemoryPersistenceManagerImpl<>();
		String id = impl.create("value");
		String value = impl.fetch(id);
		assertTrue("value".equals(value));
	}

	@Test
	public void testSaveWithNullKey() {
		InMemoryPersistenceManagerImpl<String, String> impl = new InMemoryPersistenceManagerImpl<>();
		try {
			impl.save(null, "value");
		} catch (IllegalArgumentException e) {
			return;
		}
		assertTrue(false);
	}
}
