package 조건문;

import java.util.Scanner;

public class If2 {
	public static void main(String[]args) {
		
		System.out.println("성적을 입력해주세요>>");
		Scanner sc =new Scanner(System.in);
		
		
		int score = sc.nextInt();
		String grade;
		if(score>=90) {
			grade="A";
		}else if(score>=80) {
			grade="B";
		}else if(score>=70) {
			grade="C";
		}else if(score>=60) {
			grade="D";
		}else {
			grade="권총";
		}
		System.out.println("점수는" + score+ "이고 학점은" + grade + "입니다.");
		System.out.println("");
	}
}
