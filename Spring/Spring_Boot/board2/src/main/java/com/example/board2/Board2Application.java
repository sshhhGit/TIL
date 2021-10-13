package com.example.board2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.apache.ibatis.session.SqlSessionFactory;
import  org.mybatis.spring.SqlSessionFactoryBean;



@SpringBootApplication
public class Board2Application {

	public static void main(String[] args) {
		SpringApplication.run(Board2Application.class, args);
	}
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		SqlSessionFactoryBean sessionFactory=new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		return  sessionFactory.getObject();
	}


}
