package ch4;

import java.util.Scanner;

public class Elseif {
	public static void main(String[] args) {
		int jumsu;
		Scanner sc=new Scanner(System.in);
		System.out.println("점수를 입력하라");
		jumsu=sc.nextInt();
		if(jumsu>=90) {
				System.out.println("A");
		}else if(jumsu>=80) {
				System.out.println("B");
		}else if(jumsu>=70) {
				System.out.println("C");
		}else if(jumsu>=60) {
				System.out.println("D");
		}else if(jumsu>=50) {
				System.out.println("F");
		}
	}

}
