package ch8;

public class StaticVar {
	static int a=1; //static 초기화는 한번만 실행
	int b=1;
	
	void staticTest() {//메서드staticTest는 8, 9번 줄에서
		a++;			// a, b를 증가.
		b++;
		System.out.println("static var a = " + a);
		System.out.println("non static var b = " + b);
	}
}
