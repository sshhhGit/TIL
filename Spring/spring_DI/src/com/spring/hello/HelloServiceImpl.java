package com.spring.hello;

public class HelloServiceImpl implements HelloService{
	//전역변수 = 필드 = 프로퍼티
	private String name;
	
	public HelloServiceImpl() {}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println("hello!!! " + name +"님");
		
	}

}//class-end
