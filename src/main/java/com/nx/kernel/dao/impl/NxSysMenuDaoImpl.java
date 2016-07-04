
package com.nx.kernel.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.nx.kernel.dao.NxAbstractDao;
import com.nx.kernel.dao.NxSysMenuDao;
import com.nx.kernel.model.NxSysMenu;

@Repository
public class NxSysMenuDaoImpl extends NxAbstractDao<Integer, NxSysMenu> implements NxSysMenuDao<NxSysMenu>{

	public List<NxSysMenu> findAll() {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria()
				.add(Restrictions.isNull("parent"))
				.addOrder(Order.asc("seq"));
		return (List<NxSysMenu>)crit.list();
	}
	
	public List<NxSysMenu> findParentMenu() {
		// TODO Auto-generated method stub
		
		Criteria crit = createEntityCriteria()
				.add(Restrictions.isNull("parent"))
				.addOrder(Order.asc("seq"));
		return (List<NxSysMenu>)crit.list();
	}
	public List<NxSysMenu> findChildMenu() {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria()
				.add(Restrictions.isNotNull("parent"))
				.addOrder(Order.asc("seq"));
		return (List<NxSysMenu>)crit.list();
	}

	public void save(NxSysMenu menu) {
		// TODO Auto-generated method stub
		update(menu);
	}

	public NxSysMenu findById(int menuId) {
		Criteria crit = createEntityCriteria();
		List l = crit.add(Restrictions.eq("id", menuId)).list();
		//System.out.println("findById"+l.size());
		//System.out.println("findById"+l.get(0));
		return (NxSysMenu)l.get(0);
		 
	}

	
	
	
}
