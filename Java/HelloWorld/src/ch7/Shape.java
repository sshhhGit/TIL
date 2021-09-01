package ch7;

public class Shape {
	
	Point p = new Point(); //point의 객체형 멤버변수 p를 선언하고 생성
		//멤버변수 p가 객체, new를 해주어 메모리 할당.
	void draw() {
		System.out.println("x좌표 : " + p.x);
		System.out.println("y좌표 : " + p.y);
	}
}
