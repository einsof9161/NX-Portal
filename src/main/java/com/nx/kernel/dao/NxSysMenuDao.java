
package com.nx.kernel.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nx.kernel.model.NxSysMenu;



public interface NxSysMenuDao<T>  {
	
	public void    save(T menu);
	public void    update(T menu);
	public T       findById(int menuId);
	public List<T> findAll();
	public List<T> findParentMenu ();
	public List<T> findChildMenu ();
}
