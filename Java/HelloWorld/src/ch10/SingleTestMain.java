package ch10;

public class SingleTestMain {
	
	public static void main(String[] args) {
		// �����ڰ� private�̱� ������ Ŭ���� �ۿ��� ��ü������ �Ұ��� �ϴ�.
		// SingleTest t = new SingleTesr(); �����ڰ� private��ü �����Ұ�
		SingleTest t = SingleTest.getSingleTest();
		//SingleTest.getSingleTest()�� ȣ���ؼ� SingleTest Ŭ���� ������
		//������ SingleTest�� ��ü�� ��ȯ �޾� t�� �����Ѵ�.
		System.out.println("x = " + t.getx());
		System.out.println("y = " + t.gety());
	}
}
