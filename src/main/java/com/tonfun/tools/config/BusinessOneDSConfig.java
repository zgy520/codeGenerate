package com.tonfun.tools.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
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
* @author 张广义 E-mail:a442391947@outlook.com
* @version 创建时间：2018年6月16日 下午9:21:03
*/
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "bsOneEntityManagerFactory",
		basePackages= {"com.tonfun.tools.Model.BSOne"})
public class BusinessOneDSConfig {
	//@Primary
	@Bean(name="businessOneDataSource")
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
	//@Primary
	@Bean(name="bsOneEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean bsOneEntityManagerFactory(
			EntityManagerFactoryBuilder builder,@Qualifier("businessOneDataSource")
				DataSource dataSource) {
		return builder.dataSource(dataSource)
				.packages("com.tonfun.tools.Model.BSOne")
				.persistenceUnit("bsOne")
				.build();
	}
	//@Primary
	@Bean(name="bsOneTransactionManager")
	public PlatformTransactionManager bsOneTransactionManager(
			@Qualifier("bsOneEntityManagerFactory") EntityManagerFactory
			 bsOneEntityManagerFactory) {
		return new JpaTransactionManager(bsOneEntityManagerFactory);
	}
}
