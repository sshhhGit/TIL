package ch11;

public class GrandParent {
	protected String name; //protected ��������� ����.
	protected int age;
	
	public GrandParent() { //������
		System.out.println("GrandParent�� ������");
	}
	
	public void PrintGrandParentIntfo() {
		System.out.println("name : " + name);
		System.out.println("age : " + age);
	}
}
