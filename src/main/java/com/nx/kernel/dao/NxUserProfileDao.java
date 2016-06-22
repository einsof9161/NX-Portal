package com.nx.kernel.dao;

import java.util.List;

import com.nx.kernel.model.NxUserProfile;

public interface NxUserProfileDao<T> {
	List<T> findAll();
	
	T findByType(String type);
	
	T findById(int id);
}
