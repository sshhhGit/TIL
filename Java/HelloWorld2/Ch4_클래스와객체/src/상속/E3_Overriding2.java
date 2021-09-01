package 상속;

import java.util.Scanner;

/*
 				Calculator
 					|
 		-------------------------
 		|		|		|		|
 	   Add	   Sub	   Mul     Div
 	    |		|		| 		|
 		C				F
     ------				|
     |	  |				G
     D	  E
 */

class Calculator {
	void cal(int x, int y) {
		System.out.println("사칙연산을 시작합니다.");
	}
}

class Add extends Calculator {
	void cal(int x, int y) {
		System.out.println(x + "+" + y + "=" + (x+y)); //x+y=(x+y)
	}
}
class Sub extends Calculator {
	void cal(int x, int y) {
		System.out.println(x + "-" + y + "=" + (x-y));
	}
}
class Mul extends Calculator {
	void cal(int x, int y) {
		System.out.println(x + "*" + y + "=" + (x*y));
	}
}
class Div extends Calculator {
	void cal(int x, int y) {
		System.out.println(x + "/" + y + "=" + (x/y));
	}
}
public class E3_Overriding2 {
	public static void main(String [] args) {
	//오버라이딩 이해
		Calculator add = new Add();
		Calculator sub = new Sub();
		
		add.cal(10,20);
		sub.cal(100,50);
		
	//실습 
		System.out.println("연산을 선택해주세요(+,-,*,/)>>");
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		String str = sc.next();
		int y = sc.nextInt();
		
		if(str.equals("+")) {
			Calculator add2 = new Add();
			add2.cal(x, y);
		}else if(str.equals("-")) {
			Calculator sub2 = new Sub();
			sub2.cal(x, y);
		}else if(str.equals("*")) {
			Calculator mul2 = new Mul();
			mul2.cal(x, y);
		}else if(str.equals("/")) {
			Calculator div2 = new Div();
			div2.cal(x, y);
		}
		
		
	}
}
