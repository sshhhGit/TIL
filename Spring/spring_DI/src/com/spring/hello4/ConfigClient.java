package com.spring.hello4;
//import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ConfigClient {
	public static void main(String[] args) {
		AbstractApplicationContext ct=
				new ClassPathXmlApplicationContext("config.xml");
		
		Config cf=(Config)ct.getBean("config");
		System.out.println(cf.toString());
		//실행
	}//main-end
}//class-end
