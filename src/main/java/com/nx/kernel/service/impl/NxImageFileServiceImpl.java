package com.nx.kernel.service.impl;

import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nx.kernel.dao.NxImageFileDao;
import com.nx.kernel.dao.NxUserProfileDao;
import com.nx.kernel.model.NxImageFile;
import com.nx.kernel.model.NxUserProfile;
import com.nx.kernel.service.NxImageFileService;
import com.nx.kernel.service.NxUserProfileService;


@Service
@Transactional
public class NxImageFileServiceImpl implements NxImageFileService<NxImageFile>{
	
	@Autowired
	NxImageFileDao<NxImageFile> dao;

	public List<NxImageFile> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public NxImageFile findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	public void save(NxImageFile image) {
		dao.save(image);
	}

	public Blob getBlob(InputStream input,long length) {
		// TODO Auto-generated method stub
		return dao.getBlob(input, length);
	}
	
	
}
