package ch11;

public class Parent {
	public String name;
	protected int age; //��Ӱ����� Ŭ���������� ���ٰ���
	private int money;
	
	public Parent() { //������, �ڽ�Ŭ������ ��ӵ��� �ʴ´�.
		System.out.println("Parent ������");
	}
	
	public void printParentInfo() {//name, age��������� ����ϴ� �޼���
		System.out.println("name : " + name);
		System.out.println("age : " + age);
	}
	
	public int getMoney() { //private ��� money�� getter.
		return money;
	}
	
	public void setMoney(int money) { //private ���money�� setter.
		this.money = money;
		//this. Ŭ������ �޼��峪 �����ڿ��� ���簴ü�� ��Ÿ���� â�� ����.
	}
}
