package ch14;

import java.util.Scanner;

public class StrEqualsMain {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String id = "��ȣ"; 
		String pwd = "1234";
		
		System.out.print("id:");
		String id_str = sc.next();
		
		System.out.print("pwd:");
		String id_pwd = sc.next();
		
		if (id.equals(id_str) && pwd.equals(id_pwd)) {
			System.out.println("�α��� ����");
		} else {
			System.out.println("�α��� ����");
		}
		sc.close();
	}
}
