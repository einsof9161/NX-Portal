package com.nx.kernel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nx.kernel.dao.NxUserProfileDao;
import com.nx.kernel.model.NxUserProfile;


@Service("userProfileService")
@Transactional
public class NxUserProfileServiceImpl implements NxUserProfileService{
	
	@Autowired
	NxUserProfileDao dao;
	
	public List<NxUserProfile> findAll() {
		return dao.findAll();
	}

	public NxUserProfile findByType(String type){
		return dao.findByType(type);
	}

	public NxUserProfile findById(int id) {
		return dao.findById(id);
	}
}
