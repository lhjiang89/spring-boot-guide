/**
 * Copyright (c) 2016, Blackboard Inc. All Rights Reserved.
 */
package hello.aop;

import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: AOPTestController
 *
 * @Author: ljiang
 * @Date: Nov 15, 2016 3:42:37 PM
 */
@RestController
public class AOPTestController {

	@PerfLogging
	@RequestMapping("/aop_test")
	public String testAOP() {
		System.out.println("Testing AOP ...");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Testing AOP finished";
	}
}
