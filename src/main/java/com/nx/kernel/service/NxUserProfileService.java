package com.nx.kernel.service;

import java.util.List;

import com.nx.kernel.model.NxUserProfile;

public interface NxUserProfileService {
	
	List<NxUserProfile> findAll();
	
	NxUserProfile findByType(String type);
	
	NxUserProfile findById(int id);
}
