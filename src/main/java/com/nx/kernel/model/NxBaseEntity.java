/**
 * 
 */
package com.nx.kernel.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.MappedSuperclass;

/**
 * 將映射物件抽象出來
 * Table皆會有相同的屬性
 * 1.table uid
 * 2.creation date
 * 3.modified date
 * 4.delete flag
 * 5.object class
 * 6.enable
 @author edward
**/
@MappedSuperclass
public abstract class NxBaseEntity<T> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	protected String entityId;
	protected Date createDate;
	protected Date modifyDate;
	protected Date obseleteDate;
	protected String creator;
	protected String status ;
	protected String deleteFlag;
	protected String remarks;
	
	public String getEntityId() {
		return entityId;
	}
	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public Date getObseleteDate() {
		return obseleteDate;
	}
	public void setObseleteDate(Date obseleteDate) {
		this.obseleteDate = obseleteDate;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public NxBaseEntity(){ }
}
