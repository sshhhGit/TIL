package ch12;

public class UpCastingChild extends UpCastingParent {
	private int z; //클래스 멤버변수 x, y, z
	
	public UpCastingChild() { //생성자.
		x = 100;
		y = 200;
		z = 300;
	}
	
	@Override // 싱속받은 add재정의.
	public int add() {
		System.out.println("child의 add()");
		return x + y + z;
	}
	
	public int sub() { //sub메서드를 추가로 정의.
		System.out.println("child의 sub()");
		return x - y - z;
	}
	
	public int getZ() {
		return z;
	}
	
	public void setZ(int z) {
		this.z = z;
	}
}
