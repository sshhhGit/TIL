package ch12;

public class StaticParent {
	protected static String name; // static 멤버변수 name을 선언.
	static { //static 초괴화 블럭으로 name을 초기화 한다.
		name = "parent";
	}
	
	public static void printInfo() { //static메서드로 name 출력
		System.out.println("parent");
		System.out.println("name : " + name);
	}
}
