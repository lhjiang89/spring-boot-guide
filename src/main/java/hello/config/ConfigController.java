/**
 * Copyright (c) 2016, Blackboard Inc. All Rights Reserved.
 */
package hello.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: ConfigController
 *
 * @Author: ljiang
 * @Date: Nov 11, 2016 3:12:37 PM
 */
@RestController
public class ConfigController {

	@Autowired
	private RedisProperties redisProperties;

	@RequestMapping("/config")
	public Map<String, Object> readConfig() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("host", redisProperties.getHost());
		map.put("port", redisProperties.getPort());
		return map;
	}
}
