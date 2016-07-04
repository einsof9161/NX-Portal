
package com.nx.kernel.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.nx.kernel.dao.NxAbstractDao;
import com.nx.kernel.dao.NxUserDao;
import com.nx.kernel.model.user.NxUser;

@Repository
public class NxUserDaoImpl extends NxAbstractDao<Integer, NxUser> implements NxUserDao<NxUser> {

	public void save(NxUser user) {
		// TODO Auto-generated method stub
	}

	public NxUser findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public NxUser findBySSO(String sso) {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ssoId", sso));
		return (NxUser) crit.uniqueResult();
	}

	public List<NxUser> findAll() {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
		crit.setProjection(Projections.projectionList()
				.add(Projections.property("id"), "id")
				.add(Projections.property("firstName"), "firstName")
				.add(Projections.property("lastName"), "lastName")
				.add(Projections.property("email"), "email")
				.add(Projections.property("ssoId"), "ssoId"))
				.add( Restrictions.eq("state", "Active"))
				.setResultTransformer(Transformers.aliasToBean(NxUser.class));
		return crit.list();
	}

}
