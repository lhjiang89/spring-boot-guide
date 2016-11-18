/**
 * Copyright (c) 2016, Blackboard Inc. All Rights Reserved.
 */
package com.vicoder.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "my_user")
public class User implements Serializable {

	private static final long serialVersionUID = -1414598212322296524L;

	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String name;
	@Column
	private Integer age;

	public User() {

	}

	public User(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}


}
