package ch5;

import java.util.Scanner;

public class Arr3 {
	public static void main(String[] args) {
		int i, sum = 0;
		float avg;
		int [] jumsu = new int[5];
		Scanner sc = new Scanner(System.in);
		
		System.out.println("5���� ���� ������ �Է��Ͻÿ�.");
		for(i=0;i<jumsu.length;i++) {
			jumsu[i] = sc.nextInt();
			}// ���� ���ϱ�
		for(i=0;i<jumsu.length;i++) {
			sum += jumsu[i];
		}// ��� ���ϱ�
		avg = (float)sum / 5;
		System.out.println("���� = " + sum + ", ��� = " + avg);
	}
}
