package ex3;

import java.util.Scanner;

public class Q4_7_2 {
	public static void main(String[] args) {
		Scanner Input = new Scanner(System.in);
		System.out.print("입력한 숫자만큼 * 표시"+"\n"+": ");
		int a = Input.nextInt();
		for(int i=0;i<a;i++) {
			System.out.print("*");
		}
		System.out.println();
	}
}
