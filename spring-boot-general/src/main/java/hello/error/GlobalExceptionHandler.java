/**
 * Copyright (c) 2016, Blackboard Inc. All Rights Reserved.
 */
package hello.error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

/**
 * ClassName: GlobalExceptionHandler
 *
 * @Author: ljiang
 * @Date: Nov 15, 2016 11:21:08 AM
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(JSonException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ErrorResponse handleJSonException(HttpServletRequest req, JSonException e) {
		ErrorResponse body = new ErrorResponse(-1, e.getMessage(), req.getRequestURI());
		return body;
	}

	@ExceptionHandler(Throwable.class)
	public ModelAndView handleThrowable(HttpServletRequest req, Throwable e) {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("message", e.getMessage());
		mv.addObject("exception", e);
		mv.addObject("url", req.getRequestURI());
		return mv;
	}

	static class ErrorResponse {

		private int code;
		private String message;
		private String url;

		public ErrorResponse(int code, String message, String url) {
			this.code = code;
			this.message = message;
			this.url = url;
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

	}
}
