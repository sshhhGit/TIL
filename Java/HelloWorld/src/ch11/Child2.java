package ch11;

public class Child2 extends Parent2 {
	public String hobby;
	
	public Child2() { //������
		System.out.println("Child2�� ������");
	}
	
	public void printChild2Info() {
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		System.out.println("job : " + job);
		System.out.println("hobby : " + hobby);
	}

}
