/**
 * Copyright (c) 2016, Blackboard Inc. All Rights Reserved.
 */
package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * ClassName: GreetingController
 *
 * @Author: ljiang
 * @Date: Nov 9, 2016 5:54:21 PM
 */
@Controller
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	@ResponseBody
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@RequestMapping("/greeting_html")
	public String greetingHtml(@RequestParam(value = "name", defaultValue = "World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}


}
