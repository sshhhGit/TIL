package ex3;

import java.util.Scanner;

public class Q3_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n<0) 
			System.out.println(-n);
		else 
			System.out.println(n);
	}
}
