package com.spring.hello5;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.DisposableBean;

public class CartService implements InitializingBean,DisposableBean{

	String memId;//변수
	
	public CartService(String memId){//생성자
		this.memId=memId;
	}
	
 
	@Override //InitializingBean
	public void afterPropertiesSet() throws Exception {
		 System.out.println(memId+":InitializingBean.afterPropertiesSet() 호출");
		
	}
	
	@Override //DisposableBean
	public void destroy() throws Exception {
		 System.out.println(memId+":DisposableBean.destroy() 호출");
		
	}

	//사용자 정의 메서드 
	public void loadItems() {
		System.out.println("xml에서 init-method=loadItems() 호출");
	}
	
	//사용자 정의 메서드 
	public void storeItems() {
		System.out.println("xml에서 destroy-method=storeItems() 호출");
		
	}
	//위의 2개의 메서드을 xml에 설정
	
}//class-end
