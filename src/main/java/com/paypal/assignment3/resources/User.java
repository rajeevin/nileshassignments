package com.paypal.assignment3.resources;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class User {
	private String id;
	private String asset;
	private String loginTime;
	private Set<String> loggedIpAddresses = new HashSet<>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAsset() {
		return asset;
	}
	public void setAsset(String assest) {
		this.asset = assest;
	}
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	public Set<String> getLoggedIpAddresses() {
		return Collections.unmodifiableSet(loggedIpAddresses);
	}
	
	public void addIpAddress(String ipAddress) {
		loggedIpAddresses.add(ipAddress);
	}

	public String toString(){
		return "{id:"+id+",asset:"+asset+",loginTime:"+loginTime+",loggedIpAddresses:"+loggedIpAddresses+"}";
	}
}
