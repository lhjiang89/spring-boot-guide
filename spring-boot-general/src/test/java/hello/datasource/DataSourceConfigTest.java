/**
 * Copyright (c) 2016, Blackboard Inc. All Rights Reserved.
 */
package hello.datasource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * ClassName: DataSourceConfigTest
 *
 * @Author: ljiang
 * @Date: Nov 14, 2016 1:32:34 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DataSourceConfigTest {

	@Autowired
	@Qualifier("primaryJdbcTemplate")
	protected JdbcTemplate primaryJdbcTemplate;
	@Autowired
	@Qualifier("secondaryJdbcTemplate")
	protected JdbcTemplate secondaryJdbcTemplate;

	@Before
	public void setUp() {
		primaryJdbcTemplate.update("DELETE  FROM  T1 ");
		secondaryJdbcTemplate.update("DELETE  FROM  T1 ");
	}

	@Test
	public void test() throws Exception {
		// 往第一个数据源中插入两条数据
		primaryJdbcTemplate.update("insert into t1(id) values(?)", 1);
		primaryJdbcTemplate.update("insert into t1(id) values(?)", 2);
		// 往第二个数据源中插入一条数据，若插入的是第一个数据源，则会主键冲突报错
		secondaryJdbcTemplate.update("insert into t1(id) values(?)", 1);
		// 查一下第一个数据源中是否有两条数据，验证插入是否成功
		Assert.assertEquals("2", primaryJdbcTemplate.queryForObject("select count(1) from t1", String.class));
		// 查一下第一个数据源中是否有两条数据，验证插入是否成功
		Assert.assertEquals("1", secondaryJdbcTemplate.queryForObject("select count(1) from t1", String.class));
	}
}
