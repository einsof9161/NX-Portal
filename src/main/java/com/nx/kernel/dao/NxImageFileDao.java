
package com.nx.kernel.dao;

import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

public interface NxImageFileDao<T> {
	
	
	public T       findById(int id);
	public List<T> findAll();
	public void    save(T image);
	public Blob getBlob(InputStream input,long length) ;
}
