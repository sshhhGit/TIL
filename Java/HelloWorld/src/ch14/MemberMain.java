package ch14;

class Test2 { //3~6번 줄의 Test2는 toString()을 재정의하지 않은 클래스 샘플.
	public int x;
	public int y;
}

public class MemberMain {
	public static void main(String[] args) {
		System.out.println("toString()을 재정의하지 않은 객체 출력");
		Test2 t1 = new Test2();
		System.out.println("t1 : " + t1); //toString재정의 하지않아"클래스명@hash code"형태로 출력
		System.out.println("t1.toStrint() : " + t1.toString());
		
		System.out.println("\ntoSring()을 재정의한 객체 출력");
		Member m1 = new Member("aaa", "111", "서울시");//객체 m1생성.
		Member m2 = new Member("bbb", "222", "경기도");//객체 m2생성.
		System.out.println("m1 : " + m1);
		System.out.println("m2 : " + m2);
	}//19~20번 줄에서 m1, m2를 출력하는데 Member는 toString()을 재정의하였으므로
	//수정된 코드가 실행, 이 클래스는 멤버 변수값을 재정의해서 각 객체의 name, tel, address값을 출력한다
}
