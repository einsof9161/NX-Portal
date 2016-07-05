
package com.nx.kernel.dao.impl;

import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.nx.kernel.dao.NxAbstractDao;
import com.nx.kernel.dao.NxImageFileDao;
import com.nx.kernel.model.NxImageFile;
import com.nx.kernel.model.NxSysMenu;
import com.nx.kernel.model.user.NxUser;

@Repository
public class NxImageFileDaoImpl extends NxAbstractDao<Integer, NxImageFile> implements NxImageFileDao<NxImageFile> {

	public void save(NxUser user) {
		// TODO Auto-generated method stub
	}

	public NxImageFile findById(int id) {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
		List l = crit.add(Restrictions.eq("id", id)).list();
		return (NxImageFile)l.get(0);
	}

	public List<NxImageFile> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(NxImageFile image) {
		// TODO Auto-generated method stub
		saveEntity(image);
	}

	public Blob getBlob(InputStream input,long length) {
		// TODO Auto-generated method stub
		Blob blob = Hibernate.getLobCreator(getSession()).createBlob(input, length);
		return blob;
	}




}
