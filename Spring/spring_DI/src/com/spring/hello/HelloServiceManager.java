package com.spring.hello;
//요청받는 클래스 
public class HelloServiceManager {

	public static HelloService getInstance(){
		return new HelloServiceImpl();
		//spring.xml에 등록 
	}
}//class-end
