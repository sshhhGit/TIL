package com.spring.hello;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import org.springframework.core.io.ClassPathResource;

//클라이언트
public class HelloServiceClient {
	public static void main(String[] args) {
		
		//1. BeanFactory를 이용한 Container 생성
//		BeanFactory factory=
//				new XmlBeanFactory(new ClassPathResource("hello.xml"));
//	
//		HelloService service=(HelloService)factory.getBean("helloService");//빈 얻기
//		service.sayHello();
		//실행
		
		
		//2. ApplicationContext를 이용한 Container 생성
		// FileSystemXmlApplicationContext 를 이용할 때는 빈 경로를 꼭 참조 해야한다
		
		String xmlfile="C:\\__jsp\\spring_work\\spring_DI\\xml\\hello.xml";
		ApplicationContext fileCtx=
				new FileSystemXmlApplicationContext(xmlfile);
		
		HelloService service2=(HelloService)fileCtx.getBean("helloService");
		service2.sayHello();
		//실행2
		
		//3.ClassPathXmlApplicationContext를 이용한 빈 참조
		ApplicationContext ctx=new ClassPathXmlApplicationContext("hello.xml");
		HelloService service3=(HelloService)ctx.getBean("helloService");
		service3.sayHello();
		//실행3
		
		//4. spring.xml만들어서 사용
		ApplicationContext ctx2=new ClassPathXmlApplicationContext("spring.xml");
		HelloService service4=(HelloService)ctx2.getBean("helloService");
		service4.sayHello();
		//실행4
		
		//5.별칭 사용
		HelloService service5=(HelloService)ctx2.getBean("hs");
		service5.sayHello();
		//실행5
		
		//6.HelloServiceManager.java를 spring.xml등록된 빈 사용 
		ApplicationContext ctx3=new ClassPathXmlApplicationContext("spring.xml");
		HelloService service6=(HelloService)ctx3.getBean("helloBean");//빈얻기
		//HelloServiceManager.java 여기서 HelloServiceImpl 객체를 리턴 했음 
		service6.sayHello();
		//실행6
	}//main-end
}//class-end
