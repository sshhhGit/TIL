//���� 7-2
//3���� int�� �μ� a, b, c �� �ּڰ��� ���ϴ� min �޼��带 �ۼ�����.
//int min(int a, int b, int c)
package ex3;

//3���� ���������� �ּڰ� ���ϱ�
import java.util.Scanner;

public class Q7_2 {
	//-- a, b, c�� �ּڰ� ��ȯ--//
	static int min(int a, int b, int c) {
		int min = a;
		if (b < min) min = b;
		if (c < min) min = c;
		return min;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("���� a: "); int a = stdIn.nextInt();
		System.out.print("���� b: "); int b = stdIn.nextInt();
		System.out.print("���� c: "); int c = stdIn.nextInt();
		System.out.print("�ּڰ��� " + min(a, b, c) + "�Դϴ�.");
		

	}
}