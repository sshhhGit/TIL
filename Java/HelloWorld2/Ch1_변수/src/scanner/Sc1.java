package scanner;

import java.util.Scanner;

public class Sc1 {

	public static void main(String[] args) {
		
		//스캐너 : 콘솔창으로 데리터를 입력받게 해주는 프로그램이다.
		
		//1.안내문구
		System.out.println("당신의 이름과 나이를 입력해 주세요>>");
		
		//2.스캐너를 가져온다.
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		int age = sc.nextInt();
		
		System.out.println("당신의 이름은 " + name + " 이고, 나이는" + age + "입니다");
		
	}
}
