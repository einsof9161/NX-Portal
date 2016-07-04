package com.nx.kernel.model.privilege;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 * 系統權限
 *
 */
/**
 * @author edward
 *
 */
@Entity
public class NxSystemPrivilege {
	
	private NxSystemPrivilegePK id;
	private String name;
	private Set<NxPrivilegeGroup> groups = new HashSet<NxPrivilegeGroup>();
	
	@ManyToMany(cascade=CascadeType.REFRESH, mappedBy="privileges")
	public Set<NxPrivilegeGroup> getGroups() {
		return groups;
	}
	public void setGroups(Set<NxPrivilegeGroup> groups) {
		this.groups = groups;
	}

	public NxSystemPrivilege(){}
	
	public NxSystemPrivilege(String module, String privilege, String name) {
		this.id = new NxSystemPrivilegePK(module, privilege);
		this.name = name;
	}
	
	public NxSystemPrivilege(NxSystemPrivilegePK id) {
		this.id = id;
	}
	
	@EmbeddedId
	public NxSystemPrivilegePK getId() {//JPA 實體的標識屬性必須實現序列化
		return id;
	}
	public void setId(NxSystemPrivilegePK id) {
		this.id = id;
	}
	@Column(length=20,nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final NxSystemPrivilege other = (NxSystemPrivilege) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
