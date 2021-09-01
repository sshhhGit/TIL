package ch10;

public class PublicTestMain {
	
	public static void main(String[] args) {
		PublicTest t = new PublicTest(10, 10);
		t.x = 20; // public 멤버는 클래스 밖에서 접근 가능
		// t.y=20; y는 private 멤버이기 때문에 클래스 밖에서는 접근 불가
		// t.setValue() private 멤버, 접근불가
		t.print(); // public 멤버, 접근 가능
	}
}
