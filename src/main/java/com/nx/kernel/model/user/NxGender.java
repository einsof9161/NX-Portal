package com.nx.kernel.model.user;

public enum NxGender {
	
	Male{
		public String getName(){return "Male";}
	},
	Female{
		public String getName(){return "Female";}
	};
	
	public abstract String getName();
}