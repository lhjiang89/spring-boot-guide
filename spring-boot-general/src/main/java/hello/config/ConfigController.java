/**
 * Copyright (c) 2016, Blackboard Inc. All Rights Reserved.
 */
package hello.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	private LearnerProperties learnerProperties;
	@Value("${learner.name}")
	private String learnerName;
	@Value("${learner.email}")
	private String learnerEmail;

	@RequestMapping("/config")
	public Map<String, Object> readConfig(@RequestParam(required = false) String property) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (property == null) {
			map.put("name", learnerProperties.getName());
			map.put("email", learnerProperties.getEmail());
		} else if (property.contains("name")) {
			map.put("name", learnerName);
		} else if (property.contains("email")) {
			map.put("email", learnerEmail);
		}
		return map;
	}
}
