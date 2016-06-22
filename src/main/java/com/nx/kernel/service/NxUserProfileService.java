package com.nx.kernel.service;

import java.util.List;

import com.nx.kernel.model.NxUserProfile;

public interface NxUserProfileService<T> {
	
	List<T> findAll();
	
	T findByType(String type);
	
	T findById(int id);
}
