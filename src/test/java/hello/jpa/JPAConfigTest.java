/**
 * Copyright (c) 2016, Blackboard Inc. All Rights Reserved.
 */
package hello.jpa;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hello.jpa.primary.domain.T1;
import hello.jpa.primary.repo.T1Repository;
import hello.jpa.secondary.domain.T2;
import hello.jpa.secondary.repo.T2Repository;

/**
 * ClassName: JPAConfigTest
 *
 * @Author: ljiang
 * @Date: Nov 14, 2016 2:18:54 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JPAConfigTest {

	@Autowired
	private T1Repository t1Repository;
	@Autowired
	private T2Repository t2Repository;

	@Before
	public void setUp() {
		t1Repository.deleteAll();
		t2Repository.deleteAll();
	}

	@Test
	public void test() throws Exception {
		t1Repository.save(new T1(1L));
		t1Repository.save(new T1(2L));
		t1Repository.save(new T1(3L));
		t1Repository.save(new T1(4L));
		t1Repository.save(new T1(5L));
		Assert.assertEquals(5, t1Repository.findAll().size());
		t2Repository.save(new T2(1L, "Jack"));
		t2Repository.save(new T2(2L, "Tom"));
		t2Repository.save(new T2(3L, "Tim"));
		Assert.assertEquals(3, t2Repository.findAll().size());
	}

}
