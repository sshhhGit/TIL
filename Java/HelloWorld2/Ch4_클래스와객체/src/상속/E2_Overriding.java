package 상속;

//오버라이딩(VS. 오버로딩)
//   . 상속관계에서 발생
//   . 부모에 있는 메소드를 자식이 재정의 해서 사용하는 것
//   . 업캐스팅하여 부모의 오버라이딩한 메소드를 호출하면, 자식의 오버라이드 한
//     부모메소드를 스킵하고 메소드를 자동 호출한다.

class Shape	{
	Shape(){}
	void draw() {
		System.out.println("도형을 그립니다.");
	}
	void a() {
		System.out.println("저녁입니다.");
	}
}

class Line extends Shape {
	
	@Override
	void draw() {
		System.out.println("선을 그립니다.");
	}
	
	void print() {
		System.out.println("목요일");
	}
}
class Rect {
	
}
class Circle{

}

public class E2_Overriding {
	public static void main(String[] args) {
		
		Shape shap = new Shape();
		Line line = new Line();
		
		Shape sh = new Line(); //업캐스팅
		//sh.print();		//자식접근 불가
		sh.a();			//부모것은 접근가능
		sh.draw();
	}
}
