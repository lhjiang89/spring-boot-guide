/**
 * Copyright (c) 2016, Blackboard Inc. All Rights Reserved.
 */
package hello.redis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hello.redis.domain.User;

/**
 * ClassName: RedisTest
 *
 * @Author: ljiang
 * @Date: Nov 14, 2016 3:37:24 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	RedisTemplate<Long, User> redisTemplate;

	@Test
	public void test() throws Exception {
		stringRedisTemplate.opsForValue().set("aaa", "111");
		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
	}

	@Test
	public void testRedisTemplate() throws Exception {
		User user = new User(1L, "超人", 20);
		redisTemplate.opsForValue().set(user.getId(), user);
		user = new User(2L, "蝙蝠侠", 30);
		redisTemplate.opsForValue().set(user.getId(), user);
		user = new User(3L, "蜘蛛侠", 40);
		redisTemplate.opsForValue().set(user.getId(), user);
		Assert.assertEquals(20, redisTemplate.opsForValue().get(1L).getAge().longValue());
		Assert.assertEquals(30, redisTemplate.opsForValue().get(2L).getAge().longValue());
		Assert.assertEquals(40, redisTemplate.opsForValue().get(3L).getAge().longValue());
	}

}
