package ex3;

import java.util.Scanner;

public class Q3_5 {
	public static void main(String[] args) {
		int a;
		Scanner sc=new Scanner(System.in);
		System.out.print("정수 값 : ");
		a=sc.nextInt();
		if(a>0) {
			System.out.println("양수");
		} else if(a==0) {
			System.out.println("영");
	    } else if(a<0) {
	    	System.out.println("음수");
	    }
	}
}