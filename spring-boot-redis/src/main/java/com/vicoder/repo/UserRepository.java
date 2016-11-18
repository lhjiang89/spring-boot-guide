/**
 * Copyright (c) 2016, Blackboard Inc. All Rights Reserved.
 */
package com.vicoder.repo;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vicoder.domain.User;

/**
 * ClassName: UserRepository
 *
 * @Author: ljiang
 * @Date: Nov 16, 2016 5:59:19 PM
 */
@CacheConfig(cacheNames = "users")
public interface UserRepository extends JpaRepository<User, Long> {

	@Cacheable(key = "#p0")
	User findByName(String name);

	@CachePut(key = "#p0.name")
	User save(User user);

}