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
// @EnableConfigurationProperties
@ConfigurationProperties(prefix = "redis")
public class RedisProperties {

	private String host;
	private int port;
	private String aaBb;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getAaBb() {
		return aaBb;
	}

	public void setAaBb(String aaBb) {
		this.aaBb = aaBb;
	}
}
