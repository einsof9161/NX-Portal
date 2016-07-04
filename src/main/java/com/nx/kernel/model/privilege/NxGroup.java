package com.nx.kernel.model.privilege;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import com.nx.kernel.model.NxBaseEntity;


/**
 * @author edward
 *
 */

@Entity
@Table(name="NxGroup")
public class NxGroup extends NxBaseEntity<NxGroup> {
	

	@Id
	@GeneratedValue(generator = "dep-uuid")
	@GenericGenerator(name = "dep-uuid", strategy = "uuid2")
	@Column(length=60 ,unique = true)
	private String id ;
	
	@Column(length=50,nullable=false)
	private String name;
	
	@Column(length=50,nullable=false)
	private String code;
	
	@Column(length=2000,nullable=false)
	private String description;
	private String type ;
	private String site;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public NxGroup() {
		
	}
	
}
