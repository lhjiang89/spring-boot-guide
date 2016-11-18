/**
 * Copyright (c) 2016, Blackboard Inc. All Rights Reserved.
 */
package hello.datasource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * ClassName: DataSourceConfig
 * Function: TODO
 *
 * @Author: ljiang
 * @Date: Nov 14, 2016 11:26:47 AM
 */
@Configuration
public class DataSourceConfig {

	@Bean(name = "primaryDataSource")
	@Qualifier("primaryDataSource")
	@ConfigurationProperties(prefix = "datasource.primary")
	@Primary
	public DataSource primaryDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "secondaryDataSource")
	@Qualifier("secondaryDataSource")
	@ConfigurationProperties(prefix = "datasource.secondary")
	public DataSource secondaryDataSource() {
		return DataSourceBuilder.create().build();
	}

}
