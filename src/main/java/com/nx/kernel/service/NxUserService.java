/**
 * 
 */
package com.nx.kernel.service;

import java.util.List;

/**
 * @author edward
 *	User服務類
 */

public interface NxUserService<T> {

	void save(T user);
	
	T findById(int id);
	
	T findBySso(String sso);
	
	List<T> findAll();
}