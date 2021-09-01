package ch14;

class Test {
	public int x;
	public int y;
}

public class HashTestMain {
	public static void main(String[] args) {
		Test t1 = new Test(); //t1, t3는 new 연산자로 생성하고
		Test t2 = t1;			//t2는 t1의 참조값을 복사한다
		Test t3 = new Test();
		
		System.out.println("t1.hashCode():" + t1.hashCode());
		System.out.println("t2.hashCode():" + t2.hashCode());
		System.out.println("t3.hashCode():" + t3.hashCode());
	} // t2는 t1의 참조값을 복사했으므로 이 두개의 객체는 해시코드가 동일하다.
}
