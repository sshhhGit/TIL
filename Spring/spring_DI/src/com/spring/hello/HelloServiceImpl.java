package com.spring.hello;

//구현클래스
public class HelloServiceImpl implements HelloService{
	//전역변수=필드=프로퍼티
	private String name;
	
	public HelloServiceImpl(){}//디폴트 생성자 
		
	//getter/setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public void sayHello() {
		System.out.println("hello!!! "+name+"님"); 
		
	}

}//class-end
