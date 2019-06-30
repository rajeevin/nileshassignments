package com.paypal.assignment2;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/**
 * This implementation of LRU provided below feautures
 * 1. Allow generic types for key and value
 * 2. Every get by key refreshes the cache entry is present
 * 3. Null value or null key are not allowed
 * 4. Null value in put method will cause the key to be removed 
 * 
 * @author rajranjan
 *
 * @param <K> Key used in cache
 * @param <V> Value stored in cache
 */
public class LRUCache<K, V> {
	
	private final int MAX_SIZE;
	private Map<K, V> cache;
	
	public LRUCache(int maxSize)
	{
		this.MAX_SIZE = maxSize;
		cache = Collections.synchronizedMap(new LinkedHashMap<>(MAX_SIZE));
	}
	
	/**
	 * return the value stored in cache for the given key.
	 * If key is null, call is ignored and return null immediately
	 * If Key is not present returns null immediately
	 * If key is found then, the corresponding entry in the underlying presentation is refreshed to make is it recent. 
	 * @param key
	 * @return
	 */
	public synchronized V get(K key)
	{
		if(key == null) {
			return null;
		}
		V value =  cache.get(key);
		if(value == null) {
			return value;
		}
		return refreshEntry(key, value);
	}

	private V refreshEntry(K key, V value) {
		cache.remove(key);
		cache.put(key, value);
		return value;
	}
	
	/**
	 * A null key causes this method to do nothing. A null value removes they key if present in cache.
	 * If key is found in the cache already, then the entry is updated and refreshed to be become recent.
	 * If cache is found to be full then least recent entry is removed and new entry of current key is added. 
	 * @param key
	 * @param value
	 * @return return value if this key was present in the cache and this operation is replacing its value with new  one provided here.
	 */
	public synchronized V put(K key, V value) {
		if(key == null) {
			return null;
		}
		
		if(value == null) {
			return cache.remove(key);
		}
		
		V existingValue = get(key);
		if(existingValue != null) {
			cache.put(key, value);
			return existingValue;
		}
		
		return addNewEntry(key, value);
	}

	private V addNewEntry(K key, V value) {
		if(isOverflowing() ) {
			System.out.println("cache is full. Clearing an old data");
			removeLeastRecentlyUsedEntry();
		}
		return cache.put(key, value);
	}

	private boolean isOverflowing() {
		return cache.size() == MAX_SIZE;
	}
	//recently  

	private void removeLeastRecentlyUsedEntry() {
		Iterator<K> iterator = cache.keySet().iterator();
		if(iterator.hasNext())
		{
			K oldestKey = iterator.next();
			System.out.println("removing key : " + oldestKey);
			cache.remove(oldestKey);
		}
	}
	
	/**
	 * returns current size of the cache. Represents number of entry present in underlying cache representation.
	 * @return
	 */
	public int size() {
		return cache.size();
	}
	
	public static void main(String[] args) {
		System.out.println(test());
	}
	
	public static boolean test() {
		return testAddNewEntry()
				&& testAddNullKey()
				&& testAddNullKeyAndNullValue()
				&& testRemovalUsingNullValue()
				&& testSizeDoesNotExceedMaxSize()
				&& testOldestEntryRemovedOnOverFlow()
				&& testGetRefreshesEntry()
				&& testPutToReplaceWithNewValueRefreshesEntry();
	}
	
	public static boolean testAddNewEntry() {
		System.out.println("testAddNewEntry");
		LRUCache<String, String> cache = new LRUCache<>(2);
		cache.put("one", "onevalue");
		String value = cache.get("one");
		return value != null ? "onevalue".equals(value) : false;
	}
	
	public static boolean testAddNullKey() {
		System.out.println("testAddNullKey");
		LRUCache<String, String> cache = new LRUCache<>(2);
		cache.put(null, "onevalue");
		return cache.size() == 0;
	}
	
	public static boolean testAddNullKeyAndNullValue() {
		System.out.println("testAddNullKeyAndNullValue");
		LRUCache<String, String> cache = new LRUCache<>(2);
		cache.put(null, null);
		return cache.size() == 0;
	}
	
	public static boolean testRemovalUsingNullValue() {
		System.out.println("testRemovalUsingNullValue");
		LRUCache<String, String> cache = new LRUCache<>(2);
		cache.put("one", "value");
		cache.put("one", null);
		return cache.get("one") == null;
	}
	
	public static boolean testSizeDoesNotExceedMaxSize() {
		System.out.println("testSizeDoesNotExceedMaxSize");
		LRUCache<String, String> cache = new LRUCache<>(1);
		cache.put("one", "onevalue");
		cache.put("two", "twovalue");
		return cache.size() == 1;
	}
	
	public static boolean testOldestEntryRemovedOnOverFlow() {
		System.out.println("testOldestEntryRemovedOnOverFlow");
		LRUCache<String, String> cache = new LRUCache<>(1);
		cache.put("one", "onevalue");
		cache.put("two", "twovalue");
		return cache.get("one") == null;
	}
	
	public static boolean testGetRefreshesEntry() {
		System.out.println("testGetRefreshesEntry");
		LRUCache<String, String> cache = new LRUCache<>(2);
		cache.put("one", "onevalue");
		cache.put("two", "twovalue");
		cache.get("one");
		cache.put("three", "threevalue");
		return cache.get("two") == null && cache.get("one") != null;
	}
	
	public static boolean testPutToReplaceWithNewValueRefreshesEntry() {
		System.out.println("testPutToReplaceWithNewValueRefreshesEntry");
		LRUCache<String, String> cache = new LRUCache<>(2);
		cache.put("one", "onevalue");
		cache.put("two", "twovalue");
		cache.put("one", "oneNewValue");
		cache.put("three", "threevalue");
		return cache.get("two") == null && cache.get("one") != null;
	}
}
