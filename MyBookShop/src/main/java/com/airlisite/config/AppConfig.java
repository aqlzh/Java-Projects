/**
 * AppConfig.java
 *
 */
package com.airlisite.config;

import java.util.HashSet;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.alibaba.druid.pool.DruidDataSource;

/**
 *
 * @version Ver 1.0 2020年2月13日
 * @since Ver 1.0
 */
@EnableTransactionManagement
@Configuration
@ComponentScan(value="com.airlisite",excludeFilters={
		@Filter(type=FilterType.ANNOTATION,classes=Controller.class),
		@Filter(type=FilterType.ANNOTATION,classes=ControllerAdvice.class)
})
public class AppConfig {
	
	@Bean
	public DataSource dataSource(){
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUsername("root");
		dataSource.setPassword("root123");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/mybookshop?useUnicode=true&characterEncoding=UTF-8");
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() throws Exception{
		//Spring对@Configuration类会特殊处理；给容器中加组件的方法，多次调用都只是从容器中找组件
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		return jdbcTemplate;
	}
	
	//注册事务管理器在容器中
	@Bean
	public PlatformTransactionManager transactionManager() throws Exception{
		return new DataSourceTransactionManager(dataSource());
	}
}
