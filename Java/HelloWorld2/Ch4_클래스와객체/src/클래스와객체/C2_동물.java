package 클래스와객체;

class 말하기{
	//멤버변수(필드)
	String str = "화요일";    //변수선언
	int age;
	
	//생성자 : 객체를 생성하는 역할, 초기화시켜주는 역할
	//		 클래스의 이름과 같은 메소드 형태
	//		 void를 붙일 수 없다.
	
	말하기(){}  	//기본생성자 - JVM이 자동으로 컴파일 해줘서 생략가능 
	말하기(String str){
		this.str = str;
	}   //기본생성자  (생성자역활 : 객체만듬)
	
	말하기(String str, int age){
		this.str = str;
		this.age = age;
	}
	
	
	//메소드
	void print() {   //void는 return이 없다.
		String name = str;
		String tel;
	}
	void print(String str) {
		String name = str;
		//tel = "010";
	}
	void print(String str, int age) {
		String name = str;
	}
	
	String speak() {
		
		return "화요일";
	}
}

public class C2_동물 {
	public static void main(String[] args) {
		
		말하기 sp0 = new 말하기();
		말하기 sp1 = new 말하기("멍멍");
		말하기 sp2 = new 말하기("야옹~", 20);
		//    |
		//   (주소값)
		//    ------------> String str : 화요일
		//					int age : 20
		//	  				print()
		
		sp2.str = "수요일";
		sp2.print();
		sp2.print("꼬꼬댁");
		sp2.print("음메", 10);
		String s = sp2.speak();
	}
}
