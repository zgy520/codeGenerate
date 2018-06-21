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
* @version 创建时间：2018年6月16日 下午4:24:25
*/
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef="entityManagerFactory",
		basePackages= {"com.tonfun.tools.Model.sys"})
public class SysDSConfig {
	@Primary
	@Bean(name="dataSource")
	@ConfigurationProperties(prefix="spring.system-datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
	@Primary
	@Bean(name="entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,@Qualifier("dataSource") DataSource dataSource) {
		return builder.dataSource(dataSource)
					  .packages("com.tonfun.tools.Model.sys")
					  .persistenceUnit("system")
					  .build();
	}
	@Primary
	@Bean(name="transactionManager")
	public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory
						entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
	
}
