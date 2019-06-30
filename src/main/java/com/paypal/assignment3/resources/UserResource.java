package com.paypal.assignment3.resources;

import com.paypal.assignment3.persistence.PersistenceManager;

public class UserResource {
	private final PersistenceManager<String, User> persistance;
	
	public UserResource(PersistenceManager<String, User> persistance) {
		this.persistance = persistance;
	}
	
	public User getUser(String userId) throws ResourceNotFoundException {
		if(userId == null) {
			throw new ResourceNotFoundException("userId can not be null.");
		}
		User user = persistance.fetch(userId);
		if(user == null) {
			throw new ResourceNotFoundException("resource not found. userId : " + userId);
		}
		return persistance.fetch(userId);
	}
	
	public User update(String userId, User user) throws ResourceNotFoundException{
		User existingUser = getUser(userId);
		if(existingUser == null) {
			throw new ResourceNotFoundException("resource not found. userId : " + userId);
		}
		updateUserData(existingUser, user);
		
		return persistance.save(userId, user);
	}
	
	private void updateUserData(User existingUser, User newUser) throws ResourceNotFoundException{
		if(newUser.getAsset() != null) {
			existingUser.setAsset(newUser.getAsset());
		}
		if(newUser.getLoginTime() != null) {
			existingUser.setLoginTime(newUser.getLoginTime());
		}
		if(newUser.getLoggedIpAddresses() != null) {
			newUser.getLoggedIpAddresses().forEach(newIpAddress -> existingUser.addIpAddress(newIpAddress));
		}
	}

	public String create(User user) throws UnaleToCreateNewResource {
		String userId = persistance.create(user);
		if(userId == null) {
			throw new UnaleToCreateNewResource("unable to create user record at this time.");
		}
		user.setId(userId);
		return userId;
	}
	
	public Boolean detectAnomaly(String userId, String ipAddress) throws ResourceNotFoundException {
		User user = persistance.fetch(userId);
		if(user == null)
		{
			throw new ResourceNotFoundException("resource not found. userId : " + userId);
		}
		//this operation can not optimized by using trie based data structure for storing IP address rather than a set
		return user.getLoggedIpAddresses().contains(ipAddress);
	}
}
