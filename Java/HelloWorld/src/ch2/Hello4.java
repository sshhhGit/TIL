package ch2;

import java.util.Scanner;

public class Hello4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        
        if(h>0 && m>=45) {
        	System.out.print(h+" "+(m-45));
        }else if(h>0 && m<45) {
        		System.out.print(h-1+" "+(m+15));
    	}else if(h==0 && m>=45) {
    		System.out.print(h+" "+(m-45));
    	}else {
    		System.out.print(h+23+" "+(m+15));
    	}
    }
} 