package com.psl.training.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration // this annotation will tell spring that this class provide Configuration
@ComponentScan(basePackages = "com.psl.training")
@PropertySource(value="classpath:/application.properties")
public class BeanConfig {
	// Establish Connection
	// For Establishing Connection we need to create a datasource 
	// This method will use new DriverManagerDataSource
	// responsible for making Connection with database
	@Bean //("dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("url........");
		dataSource.setUsername("root");
		dataSource.setPassword("Root@1234");
		return dataSource;
	}
	
	// JDBC Template will help to execute Queries
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		// Set the JDBC DataSource to obtain connections from.
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	// Inject this Bean in EmployeeDao 
}
