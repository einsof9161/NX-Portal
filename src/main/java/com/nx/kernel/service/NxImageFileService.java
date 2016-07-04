/**
 * 
 */
package com.nx.kernel.service;

import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

/**
 * @author edward
 *	NxUploadService服務類
 */

public interface NxImageFileService<T> {
	
	public List<T> findAll();
	public T       findById(int id);
	public void    save(T image);
	public Blob getBlob(InputStream input,long length) ;
}
