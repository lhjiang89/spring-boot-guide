/**
 * Copyright (c) 2016, Blackboard Inc. All Rights Reserved.
 */
package hello.jpa.primary.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * ClassName: T1
 *
 * @Author: ljiang
 * @Date: Nov 14, 2016 2:08:59 PM
 */
@Entity
public class T1 {

	@Id
	@GeneratedValue
	private Long id;

	public T1() {
	}

	public T1(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
