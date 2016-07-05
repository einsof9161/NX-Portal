/**
 * 
 */
package com.nx.kernel.service;

import java.util.List;
import java.util.Map;

/**
 * @author edward
 *	Menu服務類
 */

public interface NxSysMenuService<T> {

	public void    save(T menu);
	public void    update(T menu);
	public T       findById(int menuId);
	public Map	   findParentKey();
	public List<T> findAll();
	public List<T> findParentMenu ();
	public List<T> findChildMenu ();
	
}