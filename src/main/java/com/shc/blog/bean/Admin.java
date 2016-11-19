package com.shc.blog.bean;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="admin")
@org.hibernate.annotations.Table(appliesTo = "admin")
@Cacheable
public class Admin implements Serializable{

	@Id
	@Column(name = "admin_id", length = 10)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer adminId;
	
	@Column(name = "user", length = 20)
	private String user;
	
	@Column(name = "pwd", length = 30)
	private String pwd;

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", user=" + user + ", pwd=" + pwd
				+ "]";
	}
	
	
}
