package ex3;

import java.util.Scanner;

public class Q3_21 {
	public static void main(String[] ags) {
		Scanner a=new Scanner(System.in);
		System.out.print("�� - ");
		int month = a.nextInt();
		switch(month) {
		case 4: case 5:
					System.out.println("��.");
					break;
		case 6: case 7:  case 8:  case 9:
					System.out.println("����.");
					break;
		case 10:
					System.out.println("����.");
					break;
		case 11: case 12: case 1: case 2: case 3:
					System.out.println("�ܿ�.");
					break;
		default:
					System.out.println("1~12�� ���̸� �Է����ּ���.");
					break;
		}
	}

}


