package ch3;

public class CastingTest {

	public static void main(String[] args) {
		int a = 12, b = 13;
		float c = 0;
		//�ڵ� ����ȯ
		//�º��� float, �캯�� int
		//�캯 ��� ���(int)�� float���� ��ȯ�Ǿ� �º� c�� ����
		c = (a+b)/2;
		System.out.println("a�� b�� ����� "+c+"�̴�.");
		
		float f = 12.5f;
		//���� ����ȯ
		a = (int)f;
		System.out.println("a="+a);
	}
}
