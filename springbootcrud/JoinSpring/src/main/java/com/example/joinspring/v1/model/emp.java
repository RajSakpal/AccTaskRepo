package com.example.joinspring.v1.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class emp {

	@Id
	@Column(name="id")
	private long id;
	
	@Column
	private String ename;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@Column
	private String dept_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dept_id", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private department department;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDept_id() {
		return dept_id;
	}

	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}

	public department getDepartment() {
		return department;
	}

	public void setDepartment(department department) {
		this.department = department;
	}
	
	
}
