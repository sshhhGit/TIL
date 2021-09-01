package ch11;

public class Parent2 extends GrandParent {
	protected String job;
	
	public Parent2() { //持失切.
		System.out.println("Parent2税 持失切");
	}
	
	public void printParentIntfo() {
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		System.out.println("job : " + job);
	}
}
