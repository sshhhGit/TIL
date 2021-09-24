package com.spring.hello5;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CartClient {
	public static void main(String[] args) {
		
		AbstractApplicationContext ct=
				new ClassPathXmlApplicationContext("cart.xml");
		
		ct.registerShutdownHook();
		
	}//main-end
}//class-end
