package com.llz.hikaris.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class HikariaaConfig {
	
	@Bean
	@ConfigurationProperties("spring.datasource")
	public HikariDataSource dataSource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}

}
