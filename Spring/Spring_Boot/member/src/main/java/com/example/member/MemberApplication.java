package com.example.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.apache.ibatis.session.SqlSessionFactory;
import  org.mybatis.spring.SqlSessionFactoryBean;


import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MemberApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberApplication.class, args);
	}

	//SqlSessionFactory 설정 
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		SqlSessionFactoryBean sessionFactory=new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		return  sessionFactory.getObject();
	}
	
	//@Bean :스프링에 필요한 객체를 생성
	//sqlSessionFactory() : MyBatis의 SqlSessionFactory를 반환한다 .
	//스프링 부트가 실행될 때 DataSource객체를  이 메서드 실행시 주입해서 결과를 만들고,
	//그 결과를 스프링내 빈으로 사용하게 된다


}
