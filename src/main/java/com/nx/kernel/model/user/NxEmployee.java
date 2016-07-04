package com.nx.kernel.model.user;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.nx.kernel.model.NxImageFile;
import com.nx.kernel.model.privilege.NxDepartment;
import com.nx.kernel.model.privilege.NxPrivilegeGroup;

/**
 * 員工實體
 *
 */
@Entity
public class NxEmployee {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	/* 主鍵,20位*/
	
	@NotNull(message="不可為空值")
	@Size(min=4, max=20,message="請輸入介於4~20個字元")
	@Column(length=20, nullable=false)
	private String username;
	
	@NotNull(message="不可為空值")
	@Size(min=4)
	@Column( nullable=false)
	private String password;
	
	@NotNull(message="不可為空值")
	@Size(min=1,max=8,message="請輸入介於1~8個字元")
	/* 姓名 10位 不能為null */
	@Column(length=8,nullable=false)
	private String realname;
	
	/* 性別 5位 不能為null */
	@NotNull(message="不可為空值")
	@Enumerated(EnumType.STRING) @Column(length=5,nullable=false)
	private NxGender gender;

	/* 學歷 10位 */
	@Column(length=10)
	private String degree;
	
	
	/* 畢業院校 20位 */
	@Column(length=20)
	private String school;

	@Size( max=18)
	/* 聯繫電話 20 */
	@Column(length=18)
	private String phone;
	
	@NotNull(message="不可為空值")
	@Size(min=1, max=40,message="不可超過40個字元")
	@Column(length=40)
	private String email;

	/* 照片 41 */ 

	@OneToOne(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
	@JoinColumn(name="image_id")
	private NxImageFile image; //只存放文件名稱,而且文件名稱採用uuid生成,圖片保存在/images/employee/[username]/目錄

	/* 員工在職狀態 true為在職,false為離職 */
	@Column(nullable=false)
	private Boolean visible = true;

	/* 員工所在部門 */
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="department_id")
	private NxDepartment department;//雙向一對多,多對一

	/* 員工具有的權限 */
	@ManyToMany(cascade=CascadeType.REFRESH, fetch=FetchType.EAGER)
	@JoinTable(name="NxGroupRel",inverseJoinColumns=@JoinColumn(name="group_id"),
	joinColumns=@JoinColumn(name="username"))
	private Set<NxPrivilegeGroup> groups = new HashSet<NxPrivilegeGroup>();




	public Set<NxPrivilegeGroup> getGroups() {
		return groups;
	}

	public void setGroups(Set<NxPrivilegeGroup> groups) {
		this.groups = groups;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}


	public NxGender getGender() {
		return gender;
	}
	public void setGender(NxGender gender) {
		this.gender = gender;
	}

	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	/*
	@OneToOne(cascade=CascadeType.ALL, optional=false)
	@JoinColumn(name="card_id")
	public IDCard getIdCard() {
		return idCard;
	}
	public void setIdCard(IDCard idCard) {
		this.idCard = idCard;
	}*/

	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public NxImageFile getImage() {
		return this.image;
	}

	public void setImage(NxImageFile image) {
		this.image = image;
	}

	public Boolean getVisible() {
		return visible;
	}
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}


	public NxDepartment getDepartment() {
		return department;
	}

	public void setDepartment(NxDepartment department) {
		this.department = department;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
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
		final NxEmployee other = (NxEmployee) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NxEmployee [username=" + username + ", password=" + password + ", realname=" + realname + ", gender="
				+ gender + ", degree=" + degree + ", school=" + school + ", phone=" + phone + ", email=" + email
				+ ", visible=" + visible + ", department=" + department + ", groups="+ groups + "]";
	}

	public NxEmployee(){}

}
