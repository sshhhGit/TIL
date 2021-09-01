package ch14;

import java.util.Scanner;

public class StrEqualsMain {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String id = "승호"; 
		String pwd = "1234";
		
		System.out.print("id:");
		String id_str = sc.next();
		
		System.out.print("pwd:");
		String id_pwd = sc.next();
		
		if (id.equals(id_str) && pwd.equals(id_pwd)) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}
		sc.close();
	}
}
