package com.nx.kernel.model.user;

public enum NxGender {
	
	MAN{
		public String getName(){return "男";}
	},WOMEN{
		public String getName(){return "女";}
	};
	
	public abstract String getName();
}