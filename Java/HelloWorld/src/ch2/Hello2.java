package ch2;

import java.util.Scanner;

public class Hello2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if(a>100 || a<0) {
            System.out.println("1~100의 점수를 입력하세요.");
        }else if(a<=100 && a>=90) {
            System.out.println("A");
        }else if(a<90 && a>=80) {
            System.out.println("B");
        }else if(a<80 && a>=70) {
        	System.out.println("C"); 
        }else if(a<70 && a>=60) {
        	System.out.println("D");	
        }else{
        	System.out.println("F");
        }
    }
}