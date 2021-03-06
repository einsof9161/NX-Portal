/**
 * 
 */
package com.nx.kernel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nx.kernel.dao.NxUserDao;
import com.nx.kernel.model.user.NxUser;
import com.nx.kernel.service.NxUserService;

/**
 * @author edward
 *	User服務類
 */

@Service("userService")
@Transactional
public class NxUserServiceImpl implements NxUserService<NxUser>{

	@Autowired
	private NxUserDao<NxUser> dao;
	
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

	public List<NxUser> findAll() {
		return dao.findAll();
	}

	
}