package ch10;

public class PublicTest {
	public int x;
	private int y; //클래스 안에서만 접근가능.
	
	public PublicTest(int x, int y) { //생성자
		this.x = x;
		this.y = y; // private 멤버. 클래스 안에서는 접근 가능
	}
	
	public void print() {
		setValue(); // private 멤버 호출, 클래스 안에서는 접근가능
		System.out.println("x = " + x + ", y = " + y);
	}
	
	private void setValue() { //setValue 접근제어 지정자는 private
		x = 100;
		y = 100;
	}
}
