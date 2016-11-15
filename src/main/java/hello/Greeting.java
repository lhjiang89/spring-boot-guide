/**
 * Copyright (c) 2016, Blackboard Inc. All Rights Reserved.
 */
package hello;

/**
 * ClassName: Greeting
 *
 * @Author: ljiang
 * @Date: Nov 9, 2016 5:53:47 PM
 */
public class Greeting {

	private final long id;
	private final String content;

	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}
