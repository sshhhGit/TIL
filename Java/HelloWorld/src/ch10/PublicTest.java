package ch10;

public class PublicTest {
	public int x;
	private int y; //Ŭ���� �ȿ����� ���ٰ���.
	
	public PublicTest(int x, int y) { //������
		this.x = x;
		this.y = y; // private ���. Ŭ���� �ȿ����� ���� ����
	}
	
	public void print() {
		setValue(); // private ��� ȣ��, Ŭ���� �ȿ����� ���ٰ���
		System.out.println("x = " + x + ", y = " + y);
	}
	
	private void setValue() { //setValue �������� �����ڴ� private
		x = 100;
		y = 100;
	}
}
