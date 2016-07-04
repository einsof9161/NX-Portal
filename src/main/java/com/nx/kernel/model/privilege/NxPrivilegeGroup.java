package com.nx.kernel.model.privilege;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.nx.kernel.model.user.NxEmployee;
/**

 */
@Entity
public class NxPrivilegeGroup {
	
	private String groupid;
	private String name;
	private Set<NxSystemPrivilege> privileges = new HashSet<NxSystemPrivilege>();
	private Set<NxEmployee> employees = new HashSet<NxEmployee>();
	
	public NxPrivilegeGroup(){}
	
	public NxPrivilegeGroup(String groupid) {
		this.groupid = groupid;
	}
	
	@ManyToMany(mappedBy="groups", cascade=CascadeType.REFRESH)
	public Set<NxEmployee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<NxEmployee> employees) {
		this.employees = employees;
	}
	
	@Id @Column(length=36)
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	@Column(length=20,nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToMany(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
	@JoinTable(name="NxGroupPrivileges", inverseJoinColumns={@JoinColumn(name="module", referencedColumnName="module"),
											  @JoinColumn(name="privilege", referencedColumnName="privilege")}
						 ,joinColumns=@JoinColumn(name="group_id"))
	public Set<NxSystemPrivilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(Set<NxSystemPrivilege> privileges) {
		this.privileges = privileges;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((groupid == null) ? 0 : groupid.hashCode());
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
		final NxPrivilegeGroup other = (NxPrivilegeGroup) obj;
		if (groupid == null) {
			if (other.groupid != null)
				return false;
		} else if (!groupid.equals(other.groupid))
			return false;
		return true;
	}
	
}

