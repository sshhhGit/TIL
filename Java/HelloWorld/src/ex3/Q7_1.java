package ex3;

import java.util.Scanner;

public class Q7_1 {
		static int signOf(int n) {
		int sign = 0;
			if(n>0)
				sign = 1;
			
			else if(n<0)
				sign = -1;
			
			return sign;
		
	}
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int x = stdin.nextInt();
		
		int s = signOf(x);
		System.out.println(s);
	}
		
}
