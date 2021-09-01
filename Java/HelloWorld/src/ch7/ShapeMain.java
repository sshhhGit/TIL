package ch7;

public class ShapeMain {
	
	public static void main(String[] args) {
		Shape s = new Shape(); //Shape 클래스 객체 s를 생성.
		s.p.x = 10;
		s.p.y = 10;
		s.draw();
	}
}
