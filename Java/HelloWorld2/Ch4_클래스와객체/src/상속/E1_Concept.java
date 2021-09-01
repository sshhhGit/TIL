package 상속;

class A {
	int a = 7;
	int b = 10;
	
	A(int a) {
		this.a = a;
		System.out.println("난 부모 클래스야");
	}
	void a(){
		System.out.println("부모메소드");
	}
}
class B extends A{  //상속 extends
	
	B(int a){
		super(a); // 첫줄에 작성, 생성자속에서 작성, 명시적으로 부모 생성자를 호출
				  // super(), this(), super.멤버, this.멤버
		
		System.out.println("난 자식의 기본생성자");
	}
	void b() {
		System.out.println("난 자식 메소드야");
	}
}
public class E1_Concept {
	public static void main(String[] args) {
		
		
		B b = new B(32);
	  //  |
	  //  --------------> a :
	  // 				  b :
	  //				  a():
	  //				 -----------
	  //				  b()
	  b.a = 100;
	  b.b = 200;
	  b.a();
	  b.b();
	  
	  //업캐스팅 : 자식이 부모로 형변환
	  A a = new B(20);
	  a.a = 100;
	  a.b = 200;
	  a.a();
	  // a.b();  -이 경우 자식의 멤버에 접근할 수 없다.
	  
	  //다운캐스팅 : 업캐스팅된 부모를 자식으로 다시 형변환
	  B b1 = (B)a;
	  b1.a= 200;
	  b1.b= 200;
	  b1.a();
	  b1.b();
	  
	}
}
