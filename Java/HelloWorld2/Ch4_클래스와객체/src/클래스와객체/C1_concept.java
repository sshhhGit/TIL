package 클래스와객체;

// 도면/설계도
class Concept {
	
	//멤버변수
	String name;
	int age;
	String phone;
	
	
	//생성자
	//	. 클래스이름과 같은 메소드
	//  . 객체를 만드는 역활
	//	. Scanner sc;
	//         sc = new Scanner();
	
	//C1_concept(){}		//기본생성자  ()<-이게 있어도 class명과 같기떄문에 생성자.
	Concept(String name, int age, String phone){
		this.name = name;
		this.age = age;
		this.phone = phone;
		
		
	}
	
	
	//메소드()
	void print() {
		
		//return 값;
	}
	
	String getName() {
		
		return name;
	}
	
}

//실행클래스
public class C1_concept{
	public static void main(String[] args) {
		
		//객체생성 - 클래스(도면)을 사용하려면
		Concept c = new Concept("홍길동", 19, "010-1111-2222");
		
	}
}














