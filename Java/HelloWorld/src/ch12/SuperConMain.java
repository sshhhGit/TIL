package ch12;

public class SuperConMain {

	public static void main(String[] args) {
		SuperConChild scc = new SuperConChild(1, 2, 3);
		//6��, ����Ŭ�������� SuperConChild�� ��ü�� �����ϴµ�,
		//�������� �Ķ���͸� �־� ȣ��
		scc.print();
	}
}
