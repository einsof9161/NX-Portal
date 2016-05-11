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

@Service("userService")
@Transactional
public class NxUserServiceImpl implements NxUserService{

	@Autowired
	private NxUserDao dao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public void save(NxUser user){
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		dao.save(user);
	}
	
	public NxUser findById(int id) {
		return dao.findById(id);
	}

	public NxUser findBySso(String sso) {
		return dao.findBySSO(sso);
	}

	
}