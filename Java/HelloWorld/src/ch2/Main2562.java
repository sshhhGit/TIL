package ch2;

import java.util.Scanner;

public class Main2562 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i, max;
		int[] arr = new int[n];
		for(i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		max = arr[0];
		for(i=0;i<arr.length;i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		System.out.println(max+"\n"+i);
	}
	
}
