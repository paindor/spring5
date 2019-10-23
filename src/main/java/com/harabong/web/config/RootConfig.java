package com.harabong.web.config;



import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@MapperScan(basePackages = {"com.hanrabong.web"})
@ComponentScan(basePackages = {"com.hanrabong.web"})
public class RootConfig {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/hanrabong");
	    dataSource.setUsername("hanrabong");
	    dataSource.setPassword("hanrabong");

	    return dataSource;
		
	}
	@Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
      SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
      factoryBean.setDataSource(this.dataSource());
      return factoryBean.getObject();
    }
    
    @Bean
    public SqlSessionTemplate sqlSession() throws Exception {
      return new SqlSessionTemplate(sqlSessionFactory());
    }


}
