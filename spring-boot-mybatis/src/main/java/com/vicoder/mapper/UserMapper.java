/**
 * Copyright (c) 2016, Blackboard Inc. All Rights Reserved.
 */
package com.vicoder.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.vicoder.domain.User;

/**
 * ClassName: UserMapper
 *
 * @Author: ljiang
 * @Date: Nov 18, 2016 10:02:02 AM
 */
@Mapper
public interface UserMapper {

	@Select("SELECT * FROM MY_USER WHERE NAME = #{name}")
	User findByName(@Param("name") String name);

	@Insert("INSERT INTO MY_USER(NAME, AGE) VALUES(#{name}, #{age})")
	int insert(@Param("name") String name, @Param("age") Integer age);

	@Insert("INSERT INTO MY_USER(NAME, AGE) VALUES(#{name}, #{age})")
	int insertUser(User user);

	@Delete("DELETE FROM MY_USER")
	int deleteAll();
}
