package ch13;

public class Child extends Parent{
	public String hobby;
	
	@Override
	public void print() { //parent���� ������ print�� child�� �°� ������
		System.out.println("child");
		System.out.println("name = " + name);
		System.out.println("age = " + age);
	}
	
	@Override
	public void test() { //��ӹ��� �߻�޼��� test�� ����.
		System.out.println("hobby = " + hobby);
	}
	
	public void parentPrint() {
		super.print(); //��Ŭ�������� �������� ����Ŭ������ �޼��带 ȣ��
	} //�����ǵ� ����Ŭ������ �޼��带 ����Ŭ�������� ȣ���Ϸ��� super�� �̿�

}
