
package com.nx.kernel.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.nx.kernel.model.NxUser;


@Repository
public class NxUserDao extends BaseDao<NxUser>  {

	
	public List<NxUser> fetchAll() {
		Session session = getCurrentSession();
		Query query = session.createQuery("from NxUser user where user.deleteFlag <> 'Y' "); 
		return query.list();
	}
	
	public NxUser fetchEntity(String uid) {
		Session session = getCurrentSession();
		Query query = session.createQuery("from NxUser user where user.account = '"+uid+"' "); 
		if(query.list()!=null) return (NxUser) query.list().get(0);
		return null;
	}

	public void deleteEntity(String uid) {
		// TODO Auto-generated method stub
		
	}
	
	
}
