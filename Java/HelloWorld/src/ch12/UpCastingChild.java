package ch12;

public class UpCastingChild extends UpCastingParent {
	private int z; //Ŭ���� ������� x, y, z
	
	public UpCastingChild() { //������.
		x = 100;
		y = 200;
		z = 300;
	}
	
	@Override // �̼ӹ��� add������.
	public int add() {
		System.out.println("child�� add()");
		return x + y + z;
	}
	
	public int sub() { //sub�޼��带 �߰��� ����.
		System.out.println("child�� sub()");
		return x - y - z;
	}
	
	public int getZ() {
		return z;
	}
	
	public void setZ(int z) {
		this.z = z;
	}
}
