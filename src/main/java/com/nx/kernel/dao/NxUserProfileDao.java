package com.nx.kernel.dao;

import java.util.List;

import com.nx.kernel.model.NxUserProfile;

public interface NxUserProfileDao {
	List<NxUserProfile> findAll();
	
	NxUserProfile findByType(String type);
	
	NxUserProfile findById(int id);
}
