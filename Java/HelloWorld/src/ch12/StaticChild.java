package ch12;

public class StaticChild extends StaticParent {
	private static int age; //멤버변수 name과 age 두개.
	
	public static void printInfo() { // 상속받은 printInfo 재정의
		System.out.println("child");
		System.out.println("name : " + name);
		System.out.println("age : " + age);
	}
	
	public static int getAge() { //getter
		return age;
	}
	
	public static void setAge(int age) { //setter.
		StaticChild.age = age;
	}

}
