package ch12;

public class SuperChild extends SuperParent {
	private int a = 20; //��ӹ��� �ʵ带 �� �����ϸ� ����Ŭ��������
//							����Ŭ������ �ʵ�� ��������
	public void print() {
		System.out.println("SuperChild�� print()");
		System.out.println("a = " + a + "\n");
		SuperCall();
	}
	//12~15�� ����Ŭ������ �ʵ�� �޼��忡 �����ϴ� �޼���.
	public void SuperCall() {
		System.out.println("super.a=" + super.a); //SupoerParent��
		super.print(); //SuperParent�� print()�̴�
	}

}
