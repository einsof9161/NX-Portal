package com.nx.kernel.model.user;

public enum NxGender {
	
	Mele{
		public String getName(){return "Mele";}
	},
	Female{
		public String getName(){return "Female";}
	};
	
	public abstract String getName();
}