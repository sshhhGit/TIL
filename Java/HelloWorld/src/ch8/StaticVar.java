package ch8;

public class StaticVar {
	static int a=1; //static �ʱ�ȭ�� �ѹ��� ����
	int b=1;
	
	void staticTest() {//�޼���staticTest�� 8, 9�� �ٿ���
		a++;			// a, b�� ����.
		b++;
		System.out.println("static var a = " + a);
		System.out.println("non static var b = " + b);
	}
}
