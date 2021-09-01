package ch2;

import java.util.Scanner;

public class Hello5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i;
        for(i=1;i<10;i++){
        	System.out.println(n+" * "+i+" = "+n*i); 
        }
    }
}