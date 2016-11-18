/**
 * Copyright (c) 2016, Blackboard Inc. All Rights Reserved.
 */
package hello.datasource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * ClassName: JDBCTemplateConfig
 *
 * @Author: ljiang
 * @Date: Nov 14, 2016 1:34:54 PM
 */
@Configuration
public class JDBCTemplateConfig {

	@Bean(name = "primaryJdbcTemplate")
	public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean(name = "secondaryJdbcTemplate")
	public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
