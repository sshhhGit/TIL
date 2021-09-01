package ch7;

public class StudentMain1 {
	public static void main(String[] args) {
		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		
		s1.name = "김태희";
		s1.kor = 90;
		s1.eng = 95;
		s1.math = 100;
		s1.sum = s1.kor + s1.eng + s1.math;
		s1.avg = (float) s1.sum / 3;
		
		System.out.println("객체 s1의 정보");
		System.out.println("이름 : " + s1.name);
		System.out.println("국어 : " + s1.kor);
		System.out.println("영어 : " + s1.eng);
		System.out.println("수학 : " + s1.math);
		System.out.println("총점 : " + s1.sum);
		System.out.println("평균 : " + s1.avg);
		
		s2.name = "원빈";
		s2.kor = 80;
		s2.eng = 90;
		s2.math = 70;
		s2.sum = s2.kor + s2.eng + s2.math;
		s2.avg = (float) s2.sum / 3;
		System.out.println();
		System.out.println("객체 s2의 정보");
		System.out.println("이름 : " + s2.name);
		System.out.println("국어 : " + s2.kor);
		System.out.println("영어 : " + s2.eng);
		System.out.println("수학 : " + s2.math);
		System.out.println("총점 : " + s2.sum);
		System.out.println("평균 : " + s2.avg);
		 
		s3.name = "아이유";
		s3.kor = 80;
		s3.eng = 90;
		s3.math = 70;
		s3.sum = s3.kor + s3.eng + s3.math;
		s3.avg = (float) s3.sum / 3;
		System.out.println();
		System.out.println("객체 s3의 정보");
		System.out.println("이름 : " + s3.name);
		System.out.println("국어 : " + s3.kor);
		System.out.println("영어 : " + s3.eng);
		System.out.println("수학 : " + s3.math);
		System.out.println("총점 : " + s3.sum);
		System.out.println("평균 : " + s3.avg);
	}
}
