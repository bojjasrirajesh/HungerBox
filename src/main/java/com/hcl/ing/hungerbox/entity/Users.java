package com.hcl.ing.hungerbox.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	private String userName;
	private String password;
	private String mobNum;
	private String eMail;
	private String roleName;
	
	
	/*@OneToMany(mappedBy="users",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Vendors> vendor;*/

	/*public List<Vendors> getVendor() {
		return vendor;
	}

	public void setVendor(List<Vendors> vendor) {
		this.vendor = vendor;
	}*/

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobNum() {
		return mobNum;
	}

	public void setMobNum(String mobNum) {
		this.mobNum = mobNum;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", password=" + password + ", mobNum=" + mobNum
				+ ", eMail=" + eMail + ", roleName=" + roleName + "]";
	}

	public Users() {
		super();
	}

	public Users(Long userId, String userName, String password, String mobNum, String eMail, String roleName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.mobNum = mobNum;
		this.eMail = eMail;
		this.roleName = roleName;
	}

}
