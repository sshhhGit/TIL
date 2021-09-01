package Cls;

class Point2{
	int x, y;
	public Point2(int x, int y) {
		this.x=x;
		this.y=y;
		
	}
	// 객체속의 값을 비교하기 위한 메소드
	public boolean equals(Point2 p) {
		if(x == p.x && y == p.y) {
			return true;
		}else {
			return false;
		}
	}
}

public class Object4 {
	public static void main(String []args) {
		Point2 a = new Point2(2, 3);
		Point2 b = new Point2(2, 3);
		Point2 c = new Point2(3, 4);
		
		if(a==b) {
			System.out.println("a==b");
		}
		if(a.equals(b)) {
			System.out.println("a와 b는 같다");
		}
		if(a.equals(c)) {
			System.out.println("a와 c는 같다");
		}
		
	}
}
