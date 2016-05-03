/**
 * 
 */
package com.nx.kernel.dao;

import java.util.List;

/**
 * @author edward
 *
 */
public interface BaseEntityOpration <T>{
	
	public List<T> fetchAll();
	
	public T fetchEntity(String uid);
	
	public void deleteEntity(String uid);
	
}
