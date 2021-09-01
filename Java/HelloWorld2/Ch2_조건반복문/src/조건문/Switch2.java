package 조건문;

import java.util.Scanner;

public class Switch2 {
	public static void main(String [] args) {
		
		int a,b;
		
		System.out.println("두개의 수와 연산기호를 선택하시오>(+, -, /, %)");
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		String op = sc.next();
		
		switch (op) {
		case "+":
			System.out.println(a + "+" + b + "="+ (a+b));
			break;
			
		case "-":
			System.out.println(a + "-" + b + "="+ (a-b));
			break;
			
			
		case "*":
			System.out.println(a + "*" + b + "="+ (a*b));
			break;
			
		case "/":
			System.out.println(a + "/" + b + "="+ (a/b));
			break;
			
		case "%":
			System.out.println(a + "%" + b + "="+ (a%b));
			break;
			
		default:
			System.out.println("그런 연산자는 없습니다.");
			
		}
	}
}
