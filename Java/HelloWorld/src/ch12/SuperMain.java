package ch12;

public class SuperMain {

		public static void main(String[] args) {
			SuperParent sp = new SuperChild(); //��ĳ�����Ͽ� ��ü�� ����
			sp.print(); //print()�� ȣ���ϸ� �����ǵ� ����Ŭ������ print()ȣ��
		} //����Ŭ������ SuperChild�� print()�� SupoerCall�� ȣ����
		  //���� Ŭ������ ��������� ����ϰ� �޼��带 ȣ��.
}
