package ch7;

public class Student {
	
	String name;
	int kor;
	int eng;
	int math;
	int sum;
	float avg;

	//총점을 계산하는 메서드
	void eval_sum() {
		sum = kor + eng + math;
	}
	
	//평균 계산하는 메서드
	void eval_avg() {
		avg = (float) sum / 3;
	}
	
	// 현 객체의 정보를 출력하는 메서드
	void print() {
		System.out.println("이름 : " + name);
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + math);
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + avg);
		
	}
}
