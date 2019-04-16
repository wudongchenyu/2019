package com.llz.mybatisplus.base.config;

import javax.sql.DataSource;

import org.apache.ibatis.logging.log4j2.Log4j2Impl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;

@Configuration
@MapperScan(basePackages = "com.llz.mybatisplus.base.mapper")
@EnableTransactionManagement
@AutoConfigureAfter(DataSourceConfiguration.class)
public class MyBatisConfiguration {
	
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;
	
	public @Bean SqlSessionFactory sqlSessionFactory() throws Exception {
		MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
		bean.setDataSource(this.dataSource);
		bean.setTypeAliasesPackage("com.llz.mybatisplus.base.entity");
		MybatisConfiguration configuration = 
				new MybatisConfiguration();
		configuration.setLogImpl(Log4j2Impl.class);
		bean.setConfiguration(configuration);
		return bean.getObject();
	}
	
	public @Bean SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
	public @Bean(name = "platformTransactionManager") PlatformTransactionManager platformTransactionManager() {
		return new DataSourceTransactionManager(this.dataSource);
	}

}
