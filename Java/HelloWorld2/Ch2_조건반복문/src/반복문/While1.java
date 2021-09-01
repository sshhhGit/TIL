package 반복문;

import java.util.Scanner;

public class While1 {
	public static void main(String[] args) {
		
		System.out.println("숫자를 입력해주세요");
		Scanner sc = new Scanner(System.in);
		
		int n = 0;
		double sum = 0;
		int i = 0;
		
		while((i=sc.nextInt()) !=0) {
			sum += i;
			n++;
		}
		System.out.println("입력된 수의 개수는 " +n+"개이며 평균은" + sum/n + "입니다.");
	}
}
