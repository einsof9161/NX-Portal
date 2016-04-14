package com.nx.kernel.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="NXLOCALE")
public class NXLocale {
	
	
	private String nxLocaleId;
	private String localeType;
	private String localeDisplayName;
	private String createDate;
	
	/**
	 * @return the localeType
	 */
	public String getLocaleType() {
		return localeType;
	}

	/**
	 * @param localeType the localeType to set
	 */
	public void setLocaleType(String localeType) {
		this.localeType = localeType;
	}

	/**
	 * @return the localeDisplayName
	 */
	public String getLocaleDisplayName() {
		return localeDisplayName;
	}

	/**
	 * @param localeDisplayName the localeDisplayName to set
	 */
	public void setLocaleDisplayName(String localeDisplayName) {
		this.localeDisplayName = localeDisplayName;
	}

	/**
	 * @return the createDate
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	/**
	 * @param nxLocaleId the nxLocaleId to set
	 */
	public void setNxLocaleId(String nxLocaleId) {
		this.nxLocaleId = nxLocaleId;
	}

	
	@Id
	@GeneratedValue(generator="uuid_gen_strategy")
	@GenericGenerator(name="uuid_gen_strategy", strategy = "uuid2")
	public String getNxLocaleId() {
		return nxLocaleId;
	}

	/**
	 * @param nxLocaleId
	 * @param localeType
	 * @param localeDisplayName
	 * @param createDate
	 */
	public NXLocale(String nxLocaleId, String localeType, String localeDisplayName, String createDate) {
		this.nxLocaleId = nxLocaleId;
		this.localeType = localeType;
		this.localeDisplayName = localeDisplayName;
		this.createDate = createDate;
	}
	public NXLocale(){}
	
	
	
}
