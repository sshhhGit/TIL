package ch11;

public class Child extends Parent { //child�� ��������� hobby�� �ƴ϶�
	private String hobby; //��ӹ��� name, age�� ���.
	
	public Child() { //������
		System.out.println("Child ������");
	}
	
	public void printInfo() {
		System.out.println("name : " + name);
		System.out.println("age : " + age);
//		System.out.println("money : " + money); �����߻�
//		money�� ��������� private����� �ڽ�Ŭ������ ��ӵ��� �ʴ´�.
		System.out.println("hobby : " + hobby);
	}
	
	public String getHobby() { //hobby�� getter.
		return hobby;
	}
	
	public void setHobby(String hobby) { //hobby�� setter.
		this.hobby = hobby;
	}

}
