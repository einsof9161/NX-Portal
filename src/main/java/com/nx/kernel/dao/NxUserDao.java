
package com.nx.kernel.dao;

import java.util.List;

import com.nx.kernel.model.NxUser;

public interface NxUserDao {
	
	void save(NxUser user);
	NxUser findById(int id);
	NxUser findBySSO(String sso);
}
