package 추상과인터페이스;

interface Call {
	
	public static final int COST = 1000;   //상수만 가능
	// int value; 변수는 선언불가
	
	public abstract void print();
	void 전화걸기(); //public abstract는 생략될 수 있다.
	//default, private, static 접근지정자를 사용한 일반 메소드를
	//포함할 수 있다.
	default void 걸기() {
		System.out.println("전화를 잘 겁니다");
	}
}
interface SNS {
	void 문자하기();
}
interface MP3{
	void 노래듣기();
}
interface Navigation{
	void 길찾기();
}
interface 아날로그핸드폰 extends Call,SNS,MP3,Navigation {    		//interface끼리는 다중상속가능
															
	void 핸드폰만들기(); 
}
class 인공지능핸드폰 implements 아날로그핸드폰{ 	//implements 다중구현가능

	@Override
	public void print() {}

	@Override
	public void 전화걸기() {
		System.out.println("전화를 겁니다.");
	}
	@Override
	public void 문자하기() {}

	@Override
	public void 노래듣기() {
		System.out.println("클래식을 듣습니다.");
	}
	@Override
	public void 길찾기() {}

	@Override
	public void 핸드폰만들기() {}
	
	void ai() {
		System.out.println("난 인공지능입니다.");
	}
}
public class 인공지능핸드폰Ex{
	public static void main(String[]args) {
		
		인공지능핸드폰 ai= new 인공지능핸드폰();
		ai.걸기();
		ai.노래듣기();
		ai.길찾기();
		ai.핸드폰만들기();
		ai.문자하기();
	}
}

