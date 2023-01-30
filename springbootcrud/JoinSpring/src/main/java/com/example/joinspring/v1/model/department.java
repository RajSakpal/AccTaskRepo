package com.example.joinspring.v1.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class department {
	
	@Id
	@Column
	private long id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;
	
	@OneToMany(targetEntity = emp.class, mappedBy = "id", orphanRemoval = false, fetch = FetchType.LAZY)
	private Set<emp> emps;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	
	
}
