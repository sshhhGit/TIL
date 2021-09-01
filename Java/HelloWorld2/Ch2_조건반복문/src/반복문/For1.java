package 반복문;

import java.util.Scanner;

public class For1 {
	public static void main(String[] args) {
		
		int sum = 0;
		System.out.println("더하고 싶은 숫자는?");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for(int i= 1; i<=10; i++) {
			
			if(i%2 == 0) {
				sum = sum+i;
				System.out.println("여기까지합계:  "+ sum);
			}
		//	sum = sum+i;
		//	 1	= 0 + 1;
		//	 3	= 1 + 2;
		//   6  = 3 + 3;
			
			//System.out.println("여기까지합계:  "+ sum);
		}
		System.out.println("최종합계:  "+ sum);
	}
}
