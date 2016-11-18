/**
 * Copyright (c) 2016, Blackboard Inc. All Rights Reserved.
 */
package hello.redis.domain;

/**
 * ClassName: User
 *
 * @Author: ljiang
 * @Date: Nov 14, 2016 4:11:06 PM
 */
public class User {
	private Long id;
	private String name;
	private Integer age;

	public User() {
	}

	public User(Long id, String name, Integer age) {
		this.id = id;
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
