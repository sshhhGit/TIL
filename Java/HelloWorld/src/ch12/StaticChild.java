package ch12;

public class StaticChild extends StaticParent {
	private static int age; //������� name�� age �ΰ�.
	
	public static void printInfo() { // ��ӹ��� printInfo ������
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
