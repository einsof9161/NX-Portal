/**
 * 
 */
package com.nx.kernel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nx.kernel.dao.NxUserDao;
import com.nx.kernel.model.NxUser;

/**
 * @author edward
 *	User服務類
 */
@Service("nxUsrServices")
@Transactional(readOnly = false)
public class NxUserServices {
	
	@Autowired
	private NxUserDao userDao ;
	
	public void setUserDao(NxUserDao userDao) {
		this.userDao = userDao;
	}

	public List<NxUser> getUser(String id) {
		return userDao.fetchAll();
	}
	
	public NxUser validateUser(String account) {
		return userDao.fetchEntity(account);
	}
	
	public NxUserServices (){}
}
