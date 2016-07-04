package com.nx.kernel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nx.kernel.dao.NxEmployeeDao;
import com.nx.kernel.model.user.NxEmployee;
import com.nx.kernel.service.NxEmployeeService;

@Service
@Transactional
public class NxEmployeeServiceImpl  implements NxEmployeeService<NxEmployee>{
	
	@Autowired
	private NxEmployeeDao<NxEmployee> dao;
	
	public boolean exist(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean validateAccount(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<NxEmployee> findAll() {
		return dao.findAll();
	}
	public NxEmployee find(int id) {
		return dao.find(id);
	}

	public void save(NxEmployee entity) {
		// TODO Auto-generated method stub
		dao.save(entity);
	}
	
	public void merge(NxEmployee entity) {
		// TODO Auto-generated method stub
		dao.merge(entity);
	}
	public NxEmployee findByAccount(String account){
		return dao.findByAccount(account);
	}

	
	/*@Override
	public void delete(Serializable... entityids) {
		if(entityids!=null && entityids.length>0){
			StringBuilder sb = new StringBuilder();
			for(int i=0 ; i < entityids.length ; i++){
				sb.append('?').append(i+2).append(',');
			}
			sb.deleteCharAt(sb.length()-1);
			Query query = getSession().createQuery("update NxEmployee o set o.visible=?1 where o.username in ("+ sb + ")");
			query.setParameter(1, false);
			for(int i=0 ; i < entityids.length ; i++){
				query.setParameter(i+2, entityids[i]);
			}
			query.executeUpdate();
		}
	}

	public boolean exist(String username){
		long count = (Long)getSession().createQuery("select count(o) from NxEmployee o where o.username=?1")
			.setParameter(1, username).uniqueResult();
		return count>0;
	}
	
	public boolean validateAccount(String username, String password){
		
		System.out.println("##########validateAccount");
		long count = (Long)getSession().createQuery("select count(o) from NxEmployee o where o.username=?1 and o.password=?2 and o.visible=?3")
		.setParameter(1, username).setParameter(2, password).setParameter(3, true).uniqueResult();
		return count>0;
	}*/
	
}

