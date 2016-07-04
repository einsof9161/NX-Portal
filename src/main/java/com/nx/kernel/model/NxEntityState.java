package com.nx.kernel.model;

public enum NxEntityState {
	ACTIVE("Active"),
	INACTIVE("Inactive"),
	DELETED("Deleted"),
	LOCKED("Locked");
	
	private String state;
	
	private NxEntityState(final String state){
		this.state = state;
	}
	
	public String getState(){
		return this.state;
	}

	@Override
	public String toString(){
		return this.state;
	}


	public String getName(){
		return this.name();
	}
}
