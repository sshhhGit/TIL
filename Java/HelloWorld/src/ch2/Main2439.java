package ch2;

import java.util.Scanner;

public class Main2439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int i, j;
        for(i=0;i<N;i++){
        	for(j=N;j>i+1;j--)
        		System.out.print(" ");
        	for(j=1;j<=i+1;j++)
        		System.out.print("*");
        		System.out.println();
        }       
    }
}