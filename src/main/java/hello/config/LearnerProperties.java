/**
 * Copyright (c) 2016, Blackboard Inc. All Rights Reserved.
 */
package hello.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: RedisProperties
 *
 * @Author: ljiang
 * @Date: Nov 11, 2016 3:05:26 PM
 */
@Configuration
@ConfigurationProperties(prefix = "learner")
public class LearnerProperties {

	private String name;
	private String email;
	private String value;
	private String number;
	private String bignumber;
	private String random10;
	private String random1020;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getBignumber() {
		return bignumber;
	}

	public void setBignumber(String bignumber) {
		this.bignumber = bignumber;
	}

	public String getRandom10() {
		return random10;
	}

	public void setRandom10(String random10) {
		this.random10 = random10;
	}

	public String getRandom1020() {
		return random1020;
	}

	public void setRandom1020(String random1020) {
		this.random1020 = random1020;
	}

}
