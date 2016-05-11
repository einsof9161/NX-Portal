
package com.nx.kernel.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nx.kernel.model.NxUser;

@Repository
public class NxUserDaoImpl extends NxAbstractDao<Integer, NxUser> implements NxUserDao{

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

	
	
}
