/**
 * Copyright (c) 2016, Blackboard Inc. All Rights Reserved.
 */
package hello.jpa;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * ClassName: JPAConfig
 *
 * @Author: ljiang
 * @Date: Nov 14, 2016 1:51:52 PM
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactoryPrimary", transactionManagerRef = "transactionManagerPrimary", basePackages = {
		"hello.jpa.primary" })
public class JPAPrimaryConfig {

	@Autowired
	@Qualifier("primaryDataSource")
	private DataSource primaryDataSource;

	@Autowired
	private JpaProperties jpaProperties;

	@Bean(name = "entityManagerFactoryPrimary")
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(primaryDataSource).properties(getVendorProperties(primaryDataSource))
				.packages("hello.jpa.primary").persistenceUnit("primaryPersistenceUnit").build();
	}

	@Bean(name = "entityManagerPrimary")
	@Primary
	public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
		return entityManagerFactoryPrimary(builder).getObject().createEntityManager();
	}

	@Primary
	@Bean(name = "transactionManagerPrimary")
	public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
	}

	private Map<String, String> getVendorProperties(DataSource dataSource) {
		return jpaProperties.getHibernateProperties(dataSource);
	}
}
