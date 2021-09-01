package ch12;

public class UpCastingParent {
	protected int x; //멤버변수 선언.
	protected int y;
	
	public UpCastingParent() { //생성자로 멤버변수를 초기화.
		x = 10;
		y = 20;
	}
	
	public int add() { //멤버변수의 합을 반환하는 메서드를 정의
		System.out.println("parent의 add()");
		return x + y;
	}
//	public int sub() { //멤버변수의 합을 반환하는 메서드를 정의
//		System.out.println("parent의 sub()");
//		return x - y;
//	}
}
