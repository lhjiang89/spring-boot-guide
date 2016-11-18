/**
 * Copyright (c) 2016, Blackboard Inc. All Rights Reserved.
 */
package hello.jpa.secondary.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * ClassName: T1
 *
 * @Author: ljiang
 * @Date: Nov 14, 2016 2:09:36 PM
 */
@Entity
public class T2 {

	@Id
	private Long id;
	@Column
	private String name;

	public T2() {
	}

	public T2(Long id, String name) {
		this.id = id;
		this.name = name;
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

}
