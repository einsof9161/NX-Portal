package com.nx.kernel.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="NXSYSMENU")
public class NxSysMenu {
	

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", unique=true, nullable=false)
	private int id;
	
	@NotEmpty
	@Column(name="MENU_ID", unique=true, nullable=false)
	private String menuId;
	
	@NotEmpty
	@Column(name="NAME", nullable=false)
	private String name;
	
	@Column(name="DESCRIPTION", nullable=true)
	private String description;
	
	@NotNull
	@Column(name="ENTITYCLASS", nullable=false)
	private String entityClass;
	
	@Column(name="ICON", nullable=true)
	private String icon;
	
	@Column(name="HYPERLINK", nullable=true)
	private String hyperlink;
	
	@NotNull
	@Column(name="SEQ", nullable=false)
	private int seq;
	
	@ManyToOne 
	private NxSysMenu parent;   
	
	
	@OneToMany( mappedBy = "parent", cascade = javax.persistence.CascadeType.ALL, fetch = javax.persistence.FetchType.EAGER )
	@Fetch(FetchMode.SUBSELECT)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	private java.util.List<NxSysMenu> children  = new ArrayList<NxSysMenu>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(String entityClass) {
		this.entityClass = entityClass;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getHyperlink() {
		return hyperlink;
	}

	public void setHyperlink(String hyperlink) {
		this.hyperlink = hyperlink;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public NxSysMenu getParent() {
		return parent;
	}

	public void setParent(NxSysMenu parent) {
		this.parent = parent;
	}

	public java.util.List<NxSysMenu> getChildren() {
		return children;
	}

	public void setChildren(java.util.List<NxSysMenu> children) {
		this.children = children;
	}


	/**
	 * 
	 */
	public NxSysMenu() {
	}

	@Override
	public String toString() {
		return "NxSysMenu [id=" + id + ", menuId=" + menuId + ", name=" + name + ", description=" + description
				+ ", entityClass=" + entityClass + ", icon=" + icon + ", hyperlink=" + hyperlink + ", seq=" + seq
				+ ", children=" + children + "]";
	}
	
	
}
