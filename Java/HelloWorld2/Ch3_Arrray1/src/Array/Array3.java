package Array;

import java.util.Scanner;

public class Array3 {
	public static void main(String[] arg) {
		
		System.out.println("배열의 방의 크기를 입력해 주세요>>");
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		
		//배열을 생성
		int []num = new int[size];
		
		int i = 0;
		while(i<size) {
			num[i] = sc.nextInt();
			if(num[i] == 0) {
				break;
			}
			i++;
			if(i==(size-1)) {
				System.out.println("마지막 하나가 남았습니다.");
			}
		}
		sc.close();
		System.out.println("배열이 생성되었습니다.");
		
		//최대값과 최소값을 뽑아내보자
		int min =1000, max =0, sum=0;
		
		for(i = 0; i < num.length; i++) {
			
			sum += num[i];
			//최대값
			if(num[i]>max) {
				max = num[i];	
			}
			//최소값
			if(num[i]<min) {
				min = num[i];
			}	
		}	
		
		System.out.println("합게: " + sum);
		System.out.println("평균: " + sum/num.length);
		System.out.println("최대값: " + max);
		System.out.println("최소값: " + min);
	}
}
