package scanner;

import java.util.Scanner;

public class Sc3 {

	public static void main(String[] args) {
		
		
		//자기소개하기
		System.out.println("이름과 나이, 키, 몸무게, 재산을 입력해주세요");
		
		Scanner my = new Scanner(System.in);
		String name = my.next();
		int age = my.nextInt();
		int height = my.nextInt();
		int weight = my.nextInt();
		int money = my.nextInt();
		
		System.out.println("이름:" + name +"  나이:" + age +"  키:"+ height +"  몸무게:"+ weight+
				" 재산:" + money );
		
		
	}

}
