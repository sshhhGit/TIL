package 클래스와객체;

// static 정적(멤버에 상반대 되는 단어로 사용)

class Car1 {
	String color;     //static을 붙이면 클래스에 마지막 값을 공유(저장되는 위치다름)
	static int speed;
	//String name;
	
	 void print() {
		//name = "홍길동";  static이 선언되있기 떄문에 사용할 수 없음
		System.out.println("색깔: " + color);
		System.out.println("속도: " + speed);
		System.out.println("++++++++++++++++");
	}
}
public class C6_StaticEx {
	public static void main(String [] args) {
		
		Car1 c1 = new Car1();
		Car1 c2 = new Car1();
		
		c1.color = "빨강";
		c1.speed = 100;
		
		c2.color = "노랑";
		c2.speed = 120;
		
		c1.print();
		c2.print();
	}
}
