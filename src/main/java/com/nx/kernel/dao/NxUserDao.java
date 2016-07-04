
package com.nx.kernel.dao;

import java.util.List;

public interface NxUserDao<T> {
	
	void save(T user);
	T findById(int id);
	T findBySSO(String sso);
	List<T> findAll();
}
