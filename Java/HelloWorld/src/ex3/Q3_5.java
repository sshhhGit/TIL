package ex3;

import java.util.Scanner;

public class Q3_5 {
	public static void main(String[] args) {
		int a;
		Scanner sc=new Scanner(System.in);
		System.out.print("���� �� : ");
		a=sc.nextInt();
		if(a>0) {
			System.out.println("���");
		} else if(a==0) {
			System.out.println("��");
	    } else if(a<0) {
	    	System.out.println("����");
	    }
	}
}