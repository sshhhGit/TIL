package ch7;

public class Shape {
	
	Point p = new Point(); //point�� ��ü�� ������� p�� �����ϰ� ����
		//������� p�� ��ü, new�� ���־� �޸� �Ҵ�.
	void draw() {
		System.out.println("x��ǥ : " + p.x);
		System.out.println("y��ǥ : " + p.y);
	}
}
