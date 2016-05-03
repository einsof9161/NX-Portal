/**
 * 
 */
package com.nx.kernel.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.nx.kernel.model.NxUser;

/**
 * @author edward
 *
 */
public abstract class BaseDao<T>  implements BaseEntityOpration<T>{
	/**
	 * Hibernate sessionFactory由Spring注入
	 **/
	@Autowired
	private SessionFactory sessionFactory;
	private Class entityClass;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	/**
	 * 取得Hibernate Session
	 **/
	public Session getCurrentSession(){  
		  return sessionFactory.openSession();
	}
	
	
}
