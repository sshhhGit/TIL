package ch14;

class Test2 { //3~6�� ���� Test2�� toString()�� ���������� ���� Ŭ���� ����.
	public int x;
	public int y;
}

public class MemberMain {
	public static void main(String[] args) {
		System.out.println("toString()�� ���������� ���� ��ü ���");
		Test2 t1 = new Test2();
		System.out.println("t1 : " + t1); //toString������ �����ʾ�"Ŭ������@hash code"���·� ���
		System.out.println("t1.toStrint() : " + t1.toString());
		
		System.out.println("\ntoSring()�� �������� ��ü ���");
		Member m1 = new Member("aaa", "111", "�����");//��ü m1����.
		Member m2 = new Member("bbb", "222", "��⵵");//��ü m2����.
		System.out.println("m1 : " + m1);
		System.out.println("m2 : " + m2);
	}//19~20�� �ٿ��� m1, m2�� ����ϴµ� Member�� toString()�� �������Ͽ����Ƿ�
	//������ �ڵ尡 ����, �� Ŭ������ ��� �������� �������ؼ� �� ��ü�� name, tel, address���� ����Ѵ�
}
