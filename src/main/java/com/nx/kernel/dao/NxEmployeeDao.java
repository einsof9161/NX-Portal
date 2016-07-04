/**
 * 
 */
package com.nx.kernel.dao;

import java.util.List;

/**
 * @author edward
 *
 */
public interface NxEmployeeDao<T> {

	public List<T> findAll();
	public T find(int id);
	public T findByAccount(String userName);
	public void save(T entity);
	public void merge(T entity);
	
	
}
