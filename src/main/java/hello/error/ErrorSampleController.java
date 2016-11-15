/**
 * Copyright (c) 2016, Blackboard Inc. All Rights Reserved.
 */
package hello.error;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * ClassName: ErrorSampleController
 *
 * @Author: ljiang
 * @Date: Nov 15, 2016 11:13:30 AM
 */
@RestController
public class ErrorSampleController {

	/**
	 * 
	 * errorSample: 500 - internal server error
	 * 
	 * @throws Exception
	 */
	@RequestMapping("/error_json")
	public void jsonErrorSample() {
		throw new JSonException("Error Sample throws one JSonException!");
	}

	@RequestMapping("/error_html")
	public ModelAndView viewErrorSample() throws Exception {
		throw new Exception("Error Sample throws Exception!");
	}
}
