package ch12;

public class SuperConChild extends SuperConParent{
	private int c;
	
	
	public SuperConChild(int a, int b, int c) { //생성자
		super(a, b); //상위클래스의 생성자를 호출하여 파라미터 전달.
		System.out.println("SuperConChild의 생성자");
		this.c = c;
	}
	
	public void print() { //멤버변수를 출력하는 메서드.
		super.print(); //상위클래스의 print()를 실행한뒤 재정의된 코드를 실행
		System.out.println("c = " + c);
	}

}
