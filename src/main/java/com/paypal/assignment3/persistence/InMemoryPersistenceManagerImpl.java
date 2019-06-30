package com.paypal.assignment3.persistence;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryPersistenceManagerImpl<K, V> extends IdGenetatablePersistenceManagerImpl<K, V> {

	private AtomicInteger idCounter = new AtomicInteger(1000); 
	
	public InMemoryPersistenceManagerImpl() {
		super(new ConcurrentHashMap<>());
	}

	@Override
	public K generateNextId() {
		return (K) String.valueOf(idCounter.incrementAndGet());
	}
}
