package com.nx.kernel.model.privilege;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.nx.kernel.model.user.NxEmployee;


@Entity
public class NxDepartment {
	
	@Id @Column(length=36)
	private String departmentid;
	
	@Column(length=100,nullable=false)
	private String name;
	
	@Column(length=200,nullable=false)
	private String descripion;
	
	@Column(nullable=false)
	private Boolean visible = true;
	
	@Column
	private Date createdate;
	
	@Column
	private Date modifydate;
	
	@Column
	private Date obseletedate;
	
	@OneToMany(mappedBy="department")
	private Set<NxEmployee> employees = new HashSet<NxEmployee>();
	
	public NxDepartment(){}
	
	public NxDepartment(String departmentid) {
		this.departmentid = departmentid;
	}
	
	public Set<NxEmployee> getEmployees() {
		return employees;
	}
	
	public void setEmployees(Set<NxEmployee> employees) {
		this.employees = employees;
	}
	
	public String getDepartmentid() {
		return departmentid;
	}
	
	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
	}
	
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
		result = prime * result
				+ ((departmentid == null) ? 0 : departmentid.hashCode());
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
		final NxDepartment other = (NxDepartment) obj;
		if (departmentid == null) {
			if (other.departmentid != null)
				return false;
		} else if (!departmentid.equals(other.departmentid))
			return false;
		return true;
	}
	
}
