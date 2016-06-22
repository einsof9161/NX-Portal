
package com.nx.kernel.dao;

import java.util.List;

import org.springframework.stereotype.Repository;



public interface NxSysMenuDao<T>  {
	List<T> findAll();
	
	T findByType(String type);
	
	T findById(int id);
}
