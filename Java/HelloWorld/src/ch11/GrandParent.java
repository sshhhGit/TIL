package ch11;

public class GrandParent {
	protected String name; //protected 멤버변수를 선언.
	protected int age;
	
	public GrandParent() { //생성자
		System.out.println("GrandParent의 생성자");
	}
	
	public void PrintGrandParentIntfo() {
		System.out.println("name : " + name);
		System.out.println("age : " + age);
	}
}
