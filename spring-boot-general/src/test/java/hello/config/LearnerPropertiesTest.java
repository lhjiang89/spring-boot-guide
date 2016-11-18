/**
 * Copyright (c) 2016, Blackboard Inc. All Rights Reserved.
 */
package hello.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * ClassName: LearnerPropertiesTest
 *
 * @Author: ljiang
 * @Date: Nov 15, 2016 1:57:51 PM
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LearnerPropertiesTest {

	@Autowired
	private LearnerProperties learnerProperties;

	@Test
	public void test() {
		System.out.println(learnerProperties.getName());
		System.out.println(learnerProperties.getEmail());
		System.out.println(learnerProperties.getValue());
		System.out.println(learnerProperties.getNumber());
		System.out.println(learnerProperties.getBignumber());
		System.out.println(learnerProperties.getRandom10());
		System.out.println(learnerProperties.getRandom1020());
	}

}
