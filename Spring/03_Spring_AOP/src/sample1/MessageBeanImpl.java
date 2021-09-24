package sample1;

public class MessageBeanImpl implements MessageBean{

	private String name;
	
	
	
	public void setName(String name) {
		this.name = name;
	}



	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			System.out.println("Hello, " + name + " 님");
	}

	
}
