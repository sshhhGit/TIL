package ch7;

public class StudentMain1 {
	public static void main(String[] args) {
		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		
		s1.name = "������";
		s1.kor = 90;
		s1.eng = 95;
		s1.math = 100;
		s1.sum = s1.kor + s1.eng + s1.math;
		s1.avg = (float) s1.sum / 3;
		
		System.out.println("��ü s1�� ����");
		System.out.println("�̸� : " + s1.name);
		System.out.println("���� : " + s1.kor);
		System.out.println("���� : " + s1.eng);
		System.out.println("���� : " + s1.math);
		System.out.println("���� : " + s1.sum);
		System.out.println("��� : " + s1.avg);
		
		s2.name = "����";
		s2.kor = 80;
		s2.eng = 90;
		s2.math = 70;
		s2.sum = s2.kor + s2.eng + s2.math;
		s2.avg = (float) s2.sum / 3;
		System.out.println();
		System.out.println("��ü s2�� ����");
		System.out.println("�̸� : " + s2.name);
		System.out.println("���� : " + s2.kor);
		System.out.println("���� : " + s2.eng);
		System.out.println("���� : " + s2.math);
		System.out.println("���� : " + s2.sum);
		System.out.println("��� : " + s2.avg);
		 
		s3.name = "������";
		s3.kor = 80;
		s3.eng = 90;
		s3.math = 70;
		s3.sum = s3.kor + s3.eng + s3.math;
		s3.avg = (float) s3.sum / 3;
		System.out.println();
		System.out.println("��ü s3�� ����");
		System.out.println("�̸� : " + s3.name);
		System.out.println("���� : " + s3.kor);
		System.out.println("���� : " + s3.eng);
		System.out.println("���� : " + s3.math);
		System.out.println("���� : " + s3.sum);
		System.out.println("��� : " + s3.avg);
	}
}
