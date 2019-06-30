package com.paypal.assignment3.persistence;

public class PersistenceManagerFactory {
	private static final PersistenceManagerFactory instance = new PersistenceManagerFactory();
	public static enum PersistanceType {IN_MEMORY};
	
	
	public static PersistenceManagerFactory getInstance() {
		return instance;
	}
	
	public <K, V> PersistenceManager<K, V> createPersistanceManager(PersistanceType persistanceType) {
		
		switch (persistanceType) {
		case IN_MEMORY:
			return new InMemoryPersistenceManagerImpl<>();
		default:
			throw new IllegalArgumentException("unsupported persustance type : " + persistanceType);
		}
	}
}
