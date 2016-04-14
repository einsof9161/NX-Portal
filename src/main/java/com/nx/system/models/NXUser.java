/**
 * 
 */
package com.nx.system.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;


/**
 * @author edward
 *
 */

@Entity
@Table(name="NXUser")
public class NXUser implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String loginName;
	private String password;
	private String no;		
	private String name;	
	private String email;	
	private String phone;	
	private String mobile;	
	private String userType;
	private String loginIp;	
	private Date loginDate;	
	private Date createDate;
	
}
