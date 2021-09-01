package ch5;

import java.util.Scanner;

public class Arr1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] intArr = new int[] { 1, 2, 3, 4, 5 };
		int i;
		// 초기화 된 값 출력
		System.out.println("초기화 된 값 출력");
		for (i = 0; i < intArr.length; i++) {
			System.out.print(intArr[i] + "\t");
		}
		System.out.println();
		
		// 사용자 입력받아 배열에 저장
		System.out.println("숫자 5개를 입력하시오.");
		for (i = 0; i < intArr.length; i++) {
			intArr[i] = sc.nextInt();
		}
		
		//배열에 저장된 값 출력
		System.out.println("배열에 저장된 값 출력.");
		for (i = 0; i < intArr.length; i++) {
			System.out.print(intArr[i] + "\t");
		}
	}
}
