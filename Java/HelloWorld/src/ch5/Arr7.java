package ch5;

import java.util.Scanner;

public class Arr7 {
	public static void main(String[] args) {
		
		// �� ����� �̸��� ������ �迭
		String[] name = new String[3];
		
		// �� ����� ����, ����, ����, ������ ������ �迭
		int[][] jumsu = new int[3][4];
		
		// �� ����� ����� ������ �迭
		float[] avg = new float[3];
		
		// Ÿ��Ʋ�� ����� ���ڿ� ���
		String[] title = {"�̸�", "����", "����", "����", "����", "���" };
		
		Scanner sc = new Scanner(System.in);
		int i, j;
		
		for(i=0;i<jumsu.length;i++) {
			
			System.out.println(i + "��° ����� ���� �Է�");
			
			// i���� ����� �̸��� �Է¹޴´�.
			System.out.print(title[0] + " �Է�: ");
			name[i] = sc.next();
			
			// i���� ���� ���� ĭ�� 0���� �ʱ�ȭ.
			jumsu[i][3] = 0;
			
			// i��° ����� ������ ������ �Է¹ް� ������ ���Ѵ�.
			for(j=0;j<jumsu[i].length - 1;j++) {
				System.out.print(title[j + 1] + "���� �Է�: ");
				jumsu[i][j] = sc.nextInt();
				
				// �Է¹��� ������ ����ĭ�� ����
				jumsu[i][3] += jumsu[i][j];
			}
			// i���� ����� ����� ����Ͽ� ����� avg �迭�� ����
			avg[i] = (float)jumsu[i][3] / 3;
			
			System.out.println();
		}
		
		// ��� Ÿ��Ʋ ���
		for(i=0;i<title.length;i++) {
			System.out.print(title[i] + "\t");
		}
		System.out.println();
		
		// ��� ���
		for(i=0;i<jumsu.length;i++) {
			// i���� ����� �̸� ���
			System.out.print(name[i] + "\t");
			
			// i��° ����� ��, ��, ��, ������ ���
			for(j=0;j<jumsu[i].length;j++) {
				System.out.print(jumsu[i][j] + "\t");
			}
			
			// i���� ����� ��� ���
			System.out.print(avg[i] + "\n");
		}
	}
}
