package ex3;

import java.util.Scanner;

public class Q4_18 {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		System.out.println("������: ");
		int n = stdin.nextInt();
		int count = 0;
		for (int i = 1; i<= n;i++)
			if(n%i==0) {
				System.out.println(i+"");
				count++;
			}
		System.out.println("\n�� �����" + count + "�� �Դϴ�.");
	}

}
