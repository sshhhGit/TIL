package ch13;

public class AbstractMain {

	public static void main(String[] args) {
		GrandParent gp = new Child(); //업캐스팅
		gp.name = "grand papa";
		gp.age = 90;
		gp.print();
		gp.test();
		System.out.println("----------------");
		Child c = new Child();
		c.name = "child momo";
		c.age = 10;
		c.hobby = "study";
		c.print();
		c.test();
		c.parentPrint();
	} //parentPrint()를 호출해 상위클래스(parent)의 print()를 호출
}
