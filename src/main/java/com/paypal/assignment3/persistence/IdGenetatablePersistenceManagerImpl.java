package com.paypal.assignment3.persistence;

import java.util.Map;

public abstract class IdGenetatablePersistenceManagerImpl<K, V> implements PersistenceManager<K, V> {

	private Map<K, V> storage;
	
	public IdGenetatablePersistenceManagerImpl(Map<K, V> storage) {
		this.storage = storage;
	}
	@Override
	public V fetch(K key) {
		return storage.get(key);
	}

	@Override
	public V save(K key, V value) {
		if(key == null || value == null) {
			throw new IllegalArgumentException("key or value can not be null.");
		}
		storage.put(key, value);
		return fetch(key);
	}
	
	@Override
	public K create(V value) {
		if(value == null) {
			throw new IllegalArgumentException("key or value can not be null.");
		}
		K key = generateNextId();
		storage.put(key, value);
		return key;
	}
	
	public abstract K generateNextId();

}
