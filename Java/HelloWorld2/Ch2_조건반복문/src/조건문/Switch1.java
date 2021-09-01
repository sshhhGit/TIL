package 조건문;

import java.util.Scanner;

public class Switch1 {
	public static void main(String[] args) {
		
		System.out.println("1~11사이의 정수를 입력해주세요>>");
		Scanner sc =new Scanner(System.in);
		int num = sc.nextInt();
		
		
		switch(num) {
			case 1:
				System.out.println("L");
			case 2:
				System.out.println("O");
			case 3:
				System.out.println("V");
			case 4:
				System.out.println("E");
				break;
			case 5:
				System.out.println("F");
			case 6:
				System.out.println("O");
			case 7:
				System.out.println("R");
			case 8:
				System.out.println("E");
			case 9:
				System.out.println("V");
			case 10:
				System.out.println("E");
			case 11:
				System.out.println("R");
			default:
				System.out.println("잘못된 숫자입니다.");
			
		}
	}
}
