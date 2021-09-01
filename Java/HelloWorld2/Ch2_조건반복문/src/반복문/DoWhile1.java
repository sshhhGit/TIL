package 반복문;

import java.util.Scanner;

public class DoWhile1 {
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		int num;
		int answer = (int)(Math.random()*100)+1;   //1~100
		System.out.println(answer);
		
		do {
			
			System.out.println("1~100중에서 어떤 숫자일까요?");
			num = sc.nextInt();
			
			if(answer==num) {
				System.out.println(cnt+"안에 맞췄습니다.");
				break;
			}else if(answer > num) {
				System.out.println("더 큰수를 입력해 주세요");
			}else {
				System.out.println("더 작은수를 입력해주세요");
			}
			
			cnt++;
		}while(true);
		sc.close();
	}
}
