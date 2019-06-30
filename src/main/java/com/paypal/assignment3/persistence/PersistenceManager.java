package com.paypal.assignment3.persistence;

public interface PersistenceManager<K, V> {
	V fetch(K key);
	V save(K key, V value);
	K create(V value);
}
