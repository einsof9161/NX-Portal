package com.nx.kernel.model.user;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.nx.kernel.model.NxEntityState;
import com.nx.kernel.model.NxUserProfile;


/**
 * @author edward
 *
 */

@Entity
@Table(name="NXUSER")
public class NxUser  {//extends NxBaseEntity<NxUser>
	
	private static final long serialVersionUID = -3616410702274976880L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty
	@Column(name="SSO_ID", unique=true, nullable=false)
	private String ssoId;
	
	@NotEmpty
	@Column(name="PASSWORD", nullable=false)
	private String password;
		
	@NotEmpty
	@Column(name="FIRST_NAME", nullable=false)
	private String firstName;

	@NotEmpty
	@Column(name="LAST_NAME", nullable=false)
	private String lastName;

	@NotEmpty
	@Column(name="EMAIL", nullable=false)
	private String email;

	@NotEmpty
	@Column(name="STATE", nullable=false)
	private String state=NxEntityState.ACTIVE.getState();

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "NXUSERPROFILEREL", 
             joinColumns = { @JoinColumn(name = "USER_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "USER_PROFILE_ID") })
	private Set<NxUserProfile> userProfiles = new HashSet<NxUserProfile>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSsoId() {
		return ssoId;
	}

	public void setSsoId(String ssoId) {
		this.ssoId = ssoId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Set<NxUserProfile> getUserProfiles() {
		return userProfiles;
	}

	public void setUserProfiles(Set<NxUserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((ssoId == null) ? 0 : ssoId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof NxUser))
			return false;
		NxUser other = (NxUser) obj;
		if (id != other.id)
			return false;
		if (ssoId == null) {
			if (other.ssoId != null)
				return false;
		} else if (!ssoId.equals(other.ssoId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", ssoId=" + ssoId + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", state=" + state + ", userProfiles=" + userProfiles +"]";
	}
}
