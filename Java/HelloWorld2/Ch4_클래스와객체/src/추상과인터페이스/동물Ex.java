package 추상과인터페이스;

// 추상(abstract) <-> 구체화 

abstract class 동물 {
	String name;
	int age;
	
	abstract void 걷다();
	abstract void 울기();
	abstract void 잠자기();
	void 웃기() {
		System.out.println("나는 웃기게 웃습니다.");
	}
}

abstract class Person extends 동물 {
	void print() {
		System.out.println("사람입니다.");
	}
}
 class Baby extends Person {

	@Override
	void 걷다() {
		System.out.println("아장아장");
	}
	@Override
	void 울기() {}
	
	@Override
	void 잠자기() {}
	
	@Override
	void print() {
		System.out.println("아기입니다.");
	}
	
}

public class 동물Ex{
	public static void main(String [] args) {
		//동물 a = new 동물();
		//Person p = new Person();
		Baby b = new Baby();
	}
}