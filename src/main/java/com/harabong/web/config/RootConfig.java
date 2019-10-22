package com.harabong.web.config;

import javax.activation.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


@Configurable
@MapperScan(basePackages = {"com.hanrabong.web"})
@ComponentScan(basePackages = {"com.hanrabong.web"})
public class RootConfig {
	@Bean
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("com.mysql.jdbc.Driver");
		hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/hanrabong?serverTimezone=UTC");
		hikariConfig.setUsername("hanrabong");
		hikariConfig.setPassword("hanrabong");
		
		
		

		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		
		return dataSource();
		
	}

}
