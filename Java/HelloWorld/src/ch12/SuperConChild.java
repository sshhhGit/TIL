package ch12;

public class SuperConChild extends SuperConParent{
	private int c;
	
	
	public SuperConChild(int a, int b, int c) { //������
		super(a, b); //����Ŭ������ �����ڸ� ȣ���Ͽ� �Ķ���� ����.
		System.out.println("SuperConChild�� ������");
		this.c = c;
	}
	
	public void print() { //��������� ����ϴ� �޼���.
		super.print(); //����Ŭ������ print()�� �����ѵ� �����ǵ� �ڵ带 ����
		System.out.println("c = " + c);
	}

}
