/**
 * Copyright (c) 2016, Blackboard Inc. All Rights Reserved.
 */
package com.vicoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.vicoder.domain.User;
import com.vicoder.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
public class ApplicationTest {

	@Autowired
	private UserMapper userMapper;

	@Before
	public void before() {
		userMapper.deleteAll();
	}

	@Test
	@Rollback
	public void findByName() throws Exception {
		userMapper.insert("AAA", 20);
		User u = userMapper.findByName("AAA");
		Assert.assertEquals(20, u.getAge().intValue());

		userMapper.insertUser(new User("BBB", 24));
		User u1 = userMapper.findByName("BBB");
		Assert.assertEquals(24, u1.getAge().intValue());

	}
}
