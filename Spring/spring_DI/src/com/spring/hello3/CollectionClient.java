package com.spring.hello3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.hello2.Computer;

public class CollectionClient {
	public static void main(String[] args) {
		ApplicationContext ct=
				new ClassPathXmlApplicationContext("collection.xml");
		//=======================================
		CollectionBean listRefBean=(CollectionBean)ct.getBean("listRefBean");
		
		listRefBean.printItemList();//객체.메서드()
		System.out.println();//줄바꿈
		//실행1
		//=======================================
		//setRefBean빈 참조
		CollectionBean setRefBean=(CollectionBean)ct.getBean("setRefBean");
		setRefBean.printItemSet();
		System.out.println();//줄바꿈
		//실행2
				
		//=======================================
		//mapRefBean빈 참조 : 직접 해보세요
		CollectionBean mapRefBean=(CollectionBean)ct.getBean("mapRefBean");
		mapRefBean.printItemMap();
		
	}//main-end
}//class-end
