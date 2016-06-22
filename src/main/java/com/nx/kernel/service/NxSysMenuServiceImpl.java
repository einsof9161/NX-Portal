package com.nx.kernel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nx.kernel.dao.NxSysMenuDao;
import com.nx.kernel.dao.NxUserProfileDao;
import com.nx.kernel.model.NxSysMenu;
import com.nx.kernel.model.NxUserProfile;


@Service("systemMenuServices")
@Transactional
public class NxSysMenuServiceImpl implements NxSysMenuService<NxSysMenu>{
	
	@Autowired
	NxSysMenuDao<NxSysMenu> dao;
	
	public List<NxSysMenu> findAll() {
		return dao.findAll();
	}

	public void save(NxSysMenu menu) {
		// TODO Auto-generated method stub
		
	}

	public NxSysMenu findById(int menuId) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
