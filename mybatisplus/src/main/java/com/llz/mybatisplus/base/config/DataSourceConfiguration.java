package com.llz.mybatisplus.base.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
@Log4j2
@Data
public class DataSourceConfiguration {
	
	private Integer minIdle;
	private Integer initialSize;
	private Integer maxActive;
	private Long maxWait;
	private Long timeBetweenEvictionRunsMillis;
	private Long minEvictableIdleTimeMillis;
	private String validationQuery;
	private Boolean testWhileIdle;
	private Boolean testOnBorrow;
	private Boolean testOnReturn;
	private Boolean poolPreparedStatements;
	private Integer maxPoolPreparedStatementPerConnectionSize;
	private String filters;
	private Boolean useGlobalDataSourceStat;

	@ConfigurationProperties(prefix = "spring.datasource")
	public @Bean(initMethod = "init", destroyMethod = "close") DataSource dataSource() {
		
		DruidDataSource source = DataSourceBuilder.create().type(DruidDataSource.class).build();
		source.setMinIdle(minIdle);
		source.setInitialSize(initialSize);
		source.setMaxActive(maxActive);
		source.setMaxWait(maxWait);
		source.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		source.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
		source.setValidationQuery(validationQuery);
		source.setTestWhileIdle(testWhileIdle);
		source.setTestOnBorrow(testOnBorrow);
		source.setTestOnReturn(testOnReturn);
		source.setPoolPreparedStatements(poolPreparedStatements);
		source.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
		try {
			source.setFilters(filters);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		source.setUseGlobalDataSourceStat(useGlobalDataSourceStat);
		log.info("数据库连接属性："+source.getMinIdle());
		return DataSourceBuilder.create().type(DruidDataSource.class).build();
	}

}
