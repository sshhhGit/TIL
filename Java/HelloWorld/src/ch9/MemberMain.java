package ch9;

public class MemberMain {

		public static void main(String[] args) {
			Member m = new Member(); //��ü ������ ������ ȣ��.
			m.print(); //�����ڰ� ����Ǹ� ������� �Ҵ��� ������ �ʱ�ȭ.
			m.setMemberData("������", "010-1111-2222", "�ν���������");
			m.print();
		}
}
