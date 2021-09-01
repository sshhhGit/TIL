package ch7;

public class StudentMain2 {
	public static void main(String[] args) {
		Student s3 = new Student();	
		s3.name = "유재석";
		s3.kor = 91;
		s3.eng = 94;
		s3.math = 99;
		s3.eval_sum();
		s3.eval_avg();
		System.out.println("객체 s3의 정보");
		s3.print();
		System.out.println();
		
		Student s4 = new Student();	
		s4.name = "박명수";
		s4.kor = 95;
		s4.eng = 92;
		s4.math = 100;
		s4.eval_sum();
		s4.eval_avg();
		System.out.println("객체 s4의 정보");
		s4.print();
		System.out.println();
		 
		Student s5 = new Student();	
		s5.name = "정준하";
		s5.kor = 60;
		s5.eng = 55;
		s5.math = 44;
		s5.eval_sum();
		s5.eval_avg();
		System.out.println("객체 s5의 정보");
		s5.print();
	}
}
