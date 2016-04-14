/**
 * 
 */
package com.nx.kernel.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * @author edward
 *苗栗縣頭份市斗煥里17鄰國校新村62號 明教光明右使 范遙 收
 */
@Entity
@Table(name="NXENTITYMDOEL")
public class NXEntityModel {
	
	@Id
	@GeneratedValue(generator="entityModelId")
	@GenericGenerator(name="entityModelId",strategy="uuid2")
	@Column(length=100)
	private String entityModelId ;
	
	@Column(nullable=false,length=128)
	private String modelName;

	private String description;
	
	private boolean isDeleted;
	
	private boolean isDisabled;
	
	private int modelIndex;
	
	private String entityGroupKey;
	
	private Date createdDate;
	
	private Date releasedDate;
				
	private Date modifiedDate;

	

	public String getEntityModelId() {
		return entityModelId;
	}

	public void setEntityModelId(String entityModelId) {
		this.entityModelId = entityModelId;
	}

	/**
	 * @return the modelName
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * @param modelName the modelName to set
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the isDeleted
	 */
	public boolean isDeleted() {
		return isDeleted;
	}

	/**
	 * @param isDeleted the isDeleted to set
	 */
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * @return the isDisabled
	 */
	public boolean isDisabled() {
		return isDisabled;
	}

	/**
	 * @param isDisabled the isDisabled to set
	 */
	public void setDisabled(boolean isDisabled) {
		this.isDisabled = isDisabled;
	}

	/**
	 * @return the modelIndex
	 */
	public int getModelIndex() {
		return modelIndex;
	}

	/**
	 * @param modelIndex the modelIndex to set
	 */
	public void setModelIndex(int modelIndex) {
		this.modelIndex = modelIndex;
	}

	/**
	 * @return the entityGroupKey
	 */
	public String getEntityGroupKey() {
		return entityGroupKey;
	}

	/**
	 * @param entityGroupKey the entityGroupKey to set
	 */
	public void setEntityGroupKey(String entityGroupKey) {
		this.entityGroupKey = entityGroupKey;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the releasedDate
	 */
	public Date getReleasedDate() {
		return releasedDate;
	}

	/**
	 * @param releasedDate the releasedDate to set
	 */
	public void setReleasedDate(Date releasedDate) {
		this.releasedDate = releasedDate;
	}

	/**
	 * @return the modifiedDate
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * @param modifiedDate the modifiedDate to set
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * @param entityModelId
	 * @param modelName
	 * @param description
	 * @param isDeleted
	 * @param isDisabled
	 * @param modelIndex
	 * @param entityGroupKey
	 * @param createdDate
	 * @param releasedDate
	 * @param modifiedDate
	 */
	public NXEntityModel(String entityModelId, String modelName, String description, boolean isDeleted,
			boolean isDisabled, int modelIndex, String entityGroupKey, Date createdDate, Date releasedDate,
			Date modifiedDate) {
		this.entityModelId = entityModelId;
		this.modelName = modelName;
		this.description = description;
		this.isDeleted = isDeleted;
		this.isDisabled = isDisabled;
		this.modelIndex = modelIndex;
		this.entityGroupKey = entityGroupKey;
		this.createdDate = createdDate;
		this.releasedDate = releasedDate;
		this.modifiedDate = modifiedDate;
	}


	
}
