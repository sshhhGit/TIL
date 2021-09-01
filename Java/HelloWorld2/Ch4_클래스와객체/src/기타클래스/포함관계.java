package 기타클래스;

class Engine{
	String type;
	int cc;
	
	public Engine(String type, int cc) {
		this.type = type;
		this.cc =cc;
		
	}
	void print() {
		System.out.println("타 입 : "+type);
		System.out.println("배기량 : "+cc + "cc");
		
	}
}
class Car{
	String Kind;
	Engine eg;
	
	public Car(String kind, Engine eg) {
		this.Kind = kind;
		this.eg = eg;
		
		
	}
	void print() {
		System.out.println("c차 종: " + Kind);
		eg.print();
		System.out.println("================");
	}
}

public class 포함관계 {
	public static void main(String[]args) {
		
		Engine eg1 = new Engine("알파엔지", 2000);
		Engine eg2 = new Engine("베타엔진", 3000);
		
		Car car1 = new Car("소나타", eg1);
		Car car2 = new Car("너나타", eg2);
		Car car3 = new Car("d나타", eg1);
		Car car4 = new Car("ddw나타", eg2);
		Car car5 = new Car("w나타", eg1);

		
		car1.print();
		car2.print();
		car3.print();
		car4.print();
		car5.print();
		
	}
}
