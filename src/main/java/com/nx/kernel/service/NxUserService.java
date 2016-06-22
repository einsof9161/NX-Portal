/**
 * 
 */
package com.nx.kernel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nx.kernel.dao.NxUserDao;
import com.nx.kernel.model.NxUser;

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