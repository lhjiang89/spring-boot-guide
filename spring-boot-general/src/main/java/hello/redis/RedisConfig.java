/**
 * Copyright (c) 2016, Blackboard Inc. All Rights Reserved.
 */
package hello.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

import hello.redis.domain.User;

/**
 * ClassName: RedisConfig
 *
 * @Author: ljiang
 * @Date: Nov 14, 2016 4:32:44 PM
 */
@Configuration
public class RedisConfig {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}

	@Bean
	public RedisTemplate<Long, User> redisTemplate(RedisConnectionFactory factory) {
		RedisTemplate<Long, User> template = new RedisTemplate<Long, User>();
		template.setConnectionFactory(jedisConnectionFactory());
		template.setKeySerializer(new GenericJackson2JsonRedisSerializer());
		template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		return template;
	}
}
