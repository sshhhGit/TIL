package ch12;

public class SuperConParent {
	private int a;
	private int b;
	
	//������, �Ķ���ͷ� ���޹��� ������ ��������� �ʱ�ȭ/
	public SuperConParent(int a, int b) {
		System.out.println("SuperConParent�� ������");
		this.a = a;
		this.b = b;
	}
	
	public void print() { //������� a, b���,
		System.out.println("a = " + a + ", b = " + b);
	}
}
