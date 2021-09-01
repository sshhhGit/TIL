package ch12;

public class StaticMain {
	public static void main(String[] args) {
		StaticParent sp = new StaticParent();
		sp.name = "static parent";
		sp.printInfo();
		System.out.println("----------");
		
		StaticChild sc = new StaticChild();
		sc.name = "static child";
		sc.setAge(10);
		sc.printInfo();
		System.out.println("---------");
		
		StaticParent spc = new StaticChild(); //��ĳ�������� ��ü����
		spc.name = "UpCasting";
		spc.printInfo();
	}
}
