
package com.nx.kernel.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.nx.kernel.model.NxSysMenu;
import com.nx.kernel.model.NxUser;
import com.nx.kernel.model.NxUserProfile;

@Repository
public class NxSysMenuDaoImpl extends NxAbstractDao<Integer, NxSysMenu> implements NxSysMenuDao<NxSysMenu>{



	public List<NxSysMenu> findAll() {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria()
				.add(Restrictions.isNull("parent"))
				.addOrder(Order.asc("seq"));
		return (List<NxSysMenu>)crit.list();
	}

	public NxSysMenu findByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	public NxSysMenu findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
