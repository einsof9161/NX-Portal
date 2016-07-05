/**
 * 
 */
package com.nx.kernel.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nx.kernel.model.user.NxEmployee;

/**
 * @author edward
 *	User服務類
 */

public interface NxEmployeeService<T> {
	
	
	/**
	 * 確認員工是否存在
	 * @param username 用戶名
	 * @return
	 */
	public boolean exist(String username);
	
	
	/**
	 * 驗證帳密
	 * @param username 用戶名
	 * @param password 密碼
	 * @return
	 */
	public boolean validateAccount(String username, String password);
	
	public List<T> findAll();
	
	public T find(int id);
	public T findByAccount(String account);
	
	public void save(T entity);
	public void update(T entity);
	public void merge(T entity);
}
