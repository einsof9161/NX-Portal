
package com.nx.kernel.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.nx.kernel.dao.NxAbstractDao;
import com.nx.kernel.dao.NxEmployeeDao;
import com.nx.kernel.model.user.NxEmployee;
import com.nx.kernel.model.user.NxUser;

@Repository
public class NxEmployeeDaoImpl extends NxAbstractDao<Integer, NxEmployee> implements NxEmployeeDao<NxEmployee> {

	
	
	public List<NxEmployee> findAll() {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
		crit.setProjection(Projections.projectionList()
				.add(Projections.property("id"), "id")
				.add(Projections.property("username"), "username")
				.add(Projections.property("realname"), "realname")
				.add(Projections.property("gender"), "gender")
				.add(Projections.property("phone"), "phone")
				.add(Projections.property("email"), "email")
				.add(Projections.property("department"), "department")
				.add(Projections.property("image"), "image"))
				.add( Restrictions.eq("visible", true))
				.setResultTransformer(Transformers.aliasToBean(NxEmployee.class));
		return crit.list();
	}

	public NxEmployee find(int id) {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
		crit.setProjection(Projections.projectionList()
				.add(Projections.property("id"), "id")
				.add(Projections.property("username"), "username")
				.add(Projections.property("realname"), "realname")
				.add(Projections.property("gender"), "gender")
				.add(Projections.property("phone"), "phone")
				.add(Projections.property("password"), "password")
				.add(Projections.property("email"), "email")
				.add(Projections.property("department"), "department")
				.add(Projections.property("image"), "image"))
				.add( Restrictions.eq("visible", true))
				.add( Restrictions.eq("id", id))
				.setResultTransformer(Transformers.aliasToBean(NxEmployee.class));
		Object result = crit.uniqueResult();
        if (result != null) {
        	NxEmployee emp = (NxEmployee) result;
        	return emp;
        }
		return null;
	}
	public NxEmployee findByAccount(String userName) {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
		System.out.println();
		crit.setProjection(Projections.projectionList()
				.add(Projections.property("id"), "id")
				.add(Projections.property("username"), "username")
				.add(Projections.property("realname"), "realname")
				.add(Projections.property("gender"), "gender")
				.add(Projections.property("phone"), "phone")
				.add(Projections.property("password"), "password")
				.add(Projections.property("email"), "email")
				.add(Projections.property("department"), "department")
				.add(Projections.property("image"), "image"))
				.add( Restrictions.eq("visible", true))
				.add( Restrictions.eq("username", userName))
				.setResultTransformer(Transformers.aliasToBean(NxEmployee.class));
		Object result = crit.uniqueResult();
        if (result != null) {
        	NxEmployee emp = (NxEmployee) result;
        	return emp;
        }
		return null;
	}
	
	
	public void merge(NxEmployee entity) {
		// TODO Auto-generated method stub
		super.mergeEntity(entity);
	}

	public void save(NxEmployee entity) {
		// TODO Auto-generated method stub
		super.saveEntity(entity);
	}

	public void update(NxEmployee entity) {
		// TODO Auto-generated method stub
		super.updateEntity(entity);
	}



}
