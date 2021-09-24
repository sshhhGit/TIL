package sample3;

public class MessageBeanImpl implements MessageBean{
	String name;

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(5000); //5초
		} catch (InterruptedException e) {}
		
		System.out.println("Hello,"+name+"님");
	}
	
}
