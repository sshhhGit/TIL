package ch8;

public class StaticMethodMain {

	public static void main(String[] args) {
		StaticMethod sm = new StaticMethod();
		StaticMethod.a = 10;
		sm.b = 20;
		StaticMethod.test(30);
	}
}
