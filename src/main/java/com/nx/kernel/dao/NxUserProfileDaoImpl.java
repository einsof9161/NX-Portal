package com.nx.kernel.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.nx.kernel.model.NxUserProfile;

@Repository("userProfileDao")
public class NxUserProfileDaoImpl extends NxAbstractDao<Integer, NxUserProfile>implements NxUserProfileDao{

	@SuppressWarnings("unchecked")
	public List<NxUserProfile> findAll(){
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("type"));
		return (List<NxUserProfile>)crit.list();
	}
	
	public NxUserProfile findById(int id) {
		return getByKey(id);
	}
	
	public NxUserProfile findByType(String type) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("type", type));
		return (NxUserProfile) crit.uniqueResult();
	}
}
