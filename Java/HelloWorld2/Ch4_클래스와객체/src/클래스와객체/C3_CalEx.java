package 클래스와객체;

class PlusMinus {
	int plus;
	int minus;
	
	PlusMinus(){ //생략가능
		
	}
	
	String plus(int x, int y) {
		plus = x+y;
		return "두수의 합은"+plus;   //Integer.toString(plus)숫자를 문자로 바꿔줌
	}
	int minus(int x, int y) {
		minus = x - y;
		
		return minus;
	}
	
}

public class C3_CalEx {
	public static void main(String[] args) {
		
		PlusMinus pm = new PlusMinus();
		
	}
}
