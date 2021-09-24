package sample2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoggingAppClient {
	public static void main(String[] args) {
		ApplicationContext ct = new ClassPathXmlApplicationContext("beans2.xml");
		
		MessageBean bb = (MessageBean)ct.getBean("target");
		bb.sayHello();
	}

}
