/**
 * 
 */
package com.nx.kernel.model;

/**
 * @author edward
 *
 */
public enum NxUserProfileType {
	
	USER("USER"),
	SUPERUSER("SUPERUSER"),
	SYSTEMMANAGER("SYSTEMMANAGER"),
	ADMIN("ADMIN");
	
	String userProfileType;
	
	private NxUserProfileType(String userProfileType){
		this.userProfileType = userProfileType;
	}
	
	public String getUserProfileType(){
		return userProfileType;
	}
	
}