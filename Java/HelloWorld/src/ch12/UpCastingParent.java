package ch12;

public class UpCastingParent {
	protected int x; //������� ����.
	protected int y;
	
	public UpCastingParent() { //�����ڷ� ��������� �ʱ�ȭ.
		x = 10;
		y = 20;
	}
	
	public int add() { //��������� ���� ��ȯ�ϴ� �޼��带 ����
		System.out.println("parent�� add()");
		return x + y;
	}
//	public int sub() { //��������� ���� ��ȯ�ϴ� �޼��带 ����
//		System.out.println("parent�� sub()");
//		return x - y;
//	}
}
