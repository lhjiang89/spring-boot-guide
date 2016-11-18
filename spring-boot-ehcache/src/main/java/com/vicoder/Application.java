/**
 * Copyright (c) 2016, Blackboard Inc. All Rights Reserved.
 */
package com.vicoder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * ClassName: Application
 *
 * @Author: ljiang
 * @Date: Nov 16, 2016 5:51:20 PM
 */
@SpringBootApplication
@EnableCaching
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
