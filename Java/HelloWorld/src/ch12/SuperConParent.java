package ch12;

public class SuperConParent {
	private int a;
	private int b;
	
	//생성자, 파라미터로 전달받은 값으로 멤버변수를 초기화/
	public SuperConParent(int a, int b) {
		System.out.println("SuperConParent의 생성자");
		this.a = a;
		this.b = b;
	}
	
	public void print() { //멤버변수 a, b출력,
		System.out.println("a = " + a + ", b = " + b);
	}
}
