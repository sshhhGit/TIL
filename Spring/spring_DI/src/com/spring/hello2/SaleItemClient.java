package com.spring.hello2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//클라이언트
public class SaleItemClient {
	public static void main(String[] args) {
		
		ApplicationContext ct=new ClassPathXmlApplicationContext("saleItem.xml");
		
		Computer pc01=(Computer)ct.getBean("pc01");
		System.out.println(pc01.getContents());
		System.out.println();//줄바꿈
		//실행1
		
		//생성자 DI
		SaleItem saleItem=(SaleItem)ct.getBean("saleItem");
		System.out.println(saleItem.display());
		System.out.println();//줄바꿈
		//실행2
		
		//setter Injection
		SaleItem saleItem2=(SaleItem)ct.getBean("saleItem2");
		System.out.println(saleItem2.display());
		//실행3
		
	}//main-end
}//class-end
