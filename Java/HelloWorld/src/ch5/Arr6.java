package ch5;

import java.util.Scanner;

public class Arr6 {
	public static void main(String[] args) {
		
		// �� ����� ����, ����, ����, ������ ������ �迭 ����
		int[][] jumsu = new int[3][4];
		
		// Ÿ��Ʋ�� ����� ���ڿ� ���
		String[] title = {"����", "����", "����", "����"};
		
		Scanner sc = new Scanner(System.in);
		int i, j;
		
		for(i=0;i<jumsu.length;i++) {
			
			//�� ���� ���� ĭ�� 0���� �ʱ�ȭ
			jumsu[i][3] = 0;
			
			//������ ������ �Է¹ް� ������ ���Ѵ�.
			System.out.println(i + "��° ���� ���� �Է�.");
			for(j=0;j<jumsu[i].length - 1;j++) {
				System.out.print(title[j] + "�����Է�.");
				jumsu[i][j] = sc.nextInt();
						
				//�Է¹��� ������ ����ĭ�� ����
				jumsu[i][3] += jumsu[i][j];
				}
			System.out.println();
		}
		// ��� Ÿ��Ʋ ���
		for(i=0;i<title.length;i++) {
			System.out.print(title[i] + "\t");
		}
		System.out.println();
		
		// ��� ���
		for(i=0;i<jumsu.length;i++) {
			for(j=0;j<jumsu[i].length;j++) {
				System.out.print(jumsu[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
