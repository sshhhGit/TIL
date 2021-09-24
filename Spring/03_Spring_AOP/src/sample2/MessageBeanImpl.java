package sample2;

//구현클래스 : 비즈니스 로직 = target
public class MessageBeanImpl implements MessageBean{

	private String name; //변수
	
	public void setName(String name){
		this.name = name;
	}
	
	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(3000); //3초 쉬었다가 메시지 출력
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("Hello, " + name + "님");
	}

	
}
