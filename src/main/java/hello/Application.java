/**
 * Copyright (c) 2016, Blackboard Inc. All Rights Reserved.
 */
package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ClassName: Application
 *
 * @Author: ljiang
 * @Date: Nov 9, 2016 5:57:16 PM
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// SpringApplication app = new SpringApplication(Application.class);
		// app.setBannerMode(Banner.Mode.OFF);
		// app.run(args);
		SpringApplication.run(Application.class, args);
	}

}
