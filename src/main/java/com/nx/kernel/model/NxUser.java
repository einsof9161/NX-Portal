package com.nx.kernel.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;


/**
 * @author edward
 *
 */

@Entity
@Table(name="NXUser")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class NxUser extends NxBaseEntity<NxUser> {
	
	private static final long serialVersionUID = -3616410702274976880L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(length=60 ,nullable=false)
	private String id ;
	
	@Column(length=50,nullable=false,unique = true)
	private String userId;
	
	@Column(length=50,nullable=false,unique = true)
	private String account;
	
	@Column(length=100,nullable=false)
	private String pwd;	
	private String firstName;
	private String lastName;
	
	private String title;	
	private String tel;	
	private String mobile;
	private String site;
	@Column(length=100,nullable=false)
	private String mail;
	
	
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	
	public NxUser() {
		System.out.println("####NxUser##");
	}
	/**
	 * @param userId
	 * @param account
	 * @param pwd
	 * @param mail
	 */
	public NxUser(String userId, String account, String pwd, String mail) {
		this.userId = userId;
		this.account = account;
		this.pwd = pwd;
		this.mail = mail;
		this.createDate = new Date();
		this.deleteFlag = "W";
	}
	
}
