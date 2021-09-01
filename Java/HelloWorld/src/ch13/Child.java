package ch13;

public class Child extends Parent{
	public String hobby;
	
	@Override
	public void print() { //parent에서 구현된 print를 child에 맞게 재정의
		System.out.println("child");
		System.out.println("name = " + name);
		System.out.println("age = " + age);
	}
	
	@Override
	public void test() { //상속받은 추상메서드 test를 구현.
		System.out.println("hobby = " + hobby);
	}
	
	public void parentPrint() {
		super.print(); //이클래스에서 재정의한 상위클래스의 메서드를 호출
	} //재정의된 상위클래스의 메서드를 하위클래스에서 호출하려면 super를 이용

}
