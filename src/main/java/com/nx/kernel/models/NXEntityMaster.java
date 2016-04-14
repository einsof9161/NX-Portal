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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * @author edward
 *
 */
@Entity
@Table(name="NXENTITYMASTER")
public class NXEntityMaster {
	
	@Id
	/*@GeneratedValue(generator="uuid_gen_strategy")
	@GenericGenerator(name="uuid_gen_strategy", strategy = "uuid2")*/
	@Column(length=35)
	private String entityId ;
	
	@Column(nullable=false,length=45)
	private String entityKey;
	
	@Column(nullable=false,length=128)
	private String name;

	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="entityMasterId")
	private Set<NXLocale> localeDisplay =new HashSet<NXLocale>(); 
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="entityMasterId")
	private Set<NXEntityModel> entityModel =new HashSet<NXEntityModel>(); 
	
	
	private String description;
	
	private boolean deleted;
	private boolean disabled;
	private boolean masterEntity;
	
	private boolean subEntity;
	
	private boolean extendsEntity;
	
	private int subIndex;
	
	private String entityGroupKey;
	
	private Date createdDate;
	
	private Date releasedDate;
				
	private Date modifiedDate;

	/**
	 * @return the id
	 */
	public String getEntityId() {
		return entityId;
	}

	/**
	 * @param id the id to set
	 */
	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	/**
	 * @return the entityKey
	 */
	public String getEntityKey() {
		return entityKey;
	}

	/**
	 * @param entityKey the entityKey to set
	 */
	public void setEntityKey(String entityKey) {
		this.entityKey = entityKey;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the deleted
	 */
	public boolean isDeleted() {
		return deleted;
	}

	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	/**
	 * @return the disabled
	 */
	public boolean isDisabled() {
		return disabled;
	}

	/**
	 * @param disabled the disabled to set
	 */
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	/**
	 * @return the masterEntity
	 */
	public boolean isMasterEntity() {
		return masterEntity;
	}

	/**
	 * @param masterEntity the masterEntity to set
	 */
	public void setMasterEntity(boolean masterEntity) {
		this.masterEntity = masterEntity;
	}

	/**
	 * @return the subEntity
	 */
	public boolean isSubEntity() {
		return subEntity;
	}

	/**
	 * @param subEntity the subEntity to set
	 */
	public void setSubEntity(boolean subEntity) {
		this.subEntity = subEntity;
	}

	/**
	 * @return the extendsEntity
	 */
	public boolean isExtendsEntity() {
		return extendsEntity;
	}

	/**
	 * @param extendsEntity the extendsEntity to set
	 */
	public void setExtendsEntity(boolean extendsEntity) {
		this.extendsEntity = extendsEntity;
	}

	/**
	 * @return the subIndex
	 */
	public int getSubIndex() {
		return subIndex;
	}

	/**
	 * @param subIndex the subIndex to set
	 */
	public void setSubIndex(int subIndex) {
		this.subIndex = subIndex;
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
	 * @return the localeDisplay
	 */
	public Set<NXLocale> getLocaleDisplay() {
		return localeDisplay;
	}

	/**
	 * @param localeDisplay the localeDisplay to set
	 */
	public void setLocaleDisplay(Set<NXLocale> localeDisplay) {
		this.localeDisplay = localeDisplay;
	}

	
	/**
	 * @return the entityModel
	 */
	public Set<NXEntityModel> getEntityModel() {
		return entityModel;
	}

	/**
	 * @param entityModel the entityModel to set
	 */
	public void setEntityModel(Set<NXEntityModel> entityModel) {
		this.entityModel = entityModel;
	}

	/**
	 * @param id
	 * @param entityKey
	 * @param name
	 * @param description
	 * @param deleted
	 * @param disabled
	 * @param masterEntity
	 * @param subEntity
	 * @param extendsEntity
	 * @param subIndex
	 * @param entityGroupKey
	 * @param createdDate
	 * @param releasedDate
	 * @param modifiedDate
	 */
	public NXEntityMaster(String entityId, String entityKey, String name, String description, boolean deleted,
			boolean disabled, boolean masterEntity, boolean subEntity, boolean extendsEntity, int subIndex,
			String entityGroupKey) {
		this.entityId = entityId;
		this.entityKey = entityKey;
		this.name = name;
		this.description = description;
		this.deleted = deleted;
		this.disabled = disabled;
		this.masterEntity = masterEntity;
		this.subEntity = subEntity;
		this.extendsEntity = extendsEntity;
		this.subIndex = subIndex;
		this.entityGroupKey = entityGroupKey;
	}

	public NXEntityMaster() {
		// TODO Auto-generated constructor stub
	}
	
}
