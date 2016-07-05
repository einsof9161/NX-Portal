package com.nx.kernel.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nx.kernel.dao.NxSysMenuDao;
import com.nx.kernel.model.NxSysMenu;
import com.nx.kernel.service.NxSysMenuService;


@Service("systemMenuServices")
@Transactional
public class NxSysMenuServiceImpl implements NxSysMenuService<NxSysMenu>{
	
	@Autowired
	NxSysMenuDao<NxSysMenu> dao;
	
	public List<NxSysMenu> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public void update(NxSysMenu menu) {
		// TODO Auto-generated method stub
		dao.update(menu);
	}

	public void save(NxSysMenu menu) {
		// TODO Auto-generated method stub
		dao.save(menu);
	}

	public NxSysMenu findById(int menuId) {
		// TODO Auto-generated method stub
		return dao.findById(menuId);
	}

	public List<NxSysMenu> findParentMenu() {
		// TODO Auto-generated method stub
		return dao.findParentMenu();
	}

	public List<NxSysMenu> findChildMenu() {
		// TODO Auto-generated method stub
		return dao.findChildMenu();
	}


	public Map findParentKey() {
		// TODO Auto-generated method stub
		List<NxSysMenu> list = dao.findParentMenu();
		Map m = new LinkedHashMap();
		for(NxSysMenu menu :list){
			m.put("parent",menu.getId());
			m.put("name",menu.getName());
		}
		return m;
	}
	

}
