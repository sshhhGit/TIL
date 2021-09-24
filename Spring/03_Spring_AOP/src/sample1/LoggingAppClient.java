package sample1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoggingAppClient {
	public static void main(String[] args) {
	
		ApplicationContext ct = new ClassPathXmlApplicationContext("beans.xml");
		
		MessageBean bb = (MessageBean)ct.getBean("proxy");
		bb.sayHello(); //target메서드를 호출했지만, LoggingAdvice 가로채기 할 것 이다
	}
}
