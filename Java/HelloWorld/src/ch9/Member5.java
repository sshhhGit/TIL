package ch9;

public class Member5 {
	String name;
	String tel;
	String address;
	
	Member5() {
		this("no name");
		System.out.println("�Ķ���Ϳ� ���� �������� this() ��");
	}
	
	Member5(String name) {
		this("test", "222", "����");
		System.out.println("�Ķ���� 1���� ���� �������� this() ��");
		System.out.println("���� ���� �Ķ���� : " + name);
	}
	
	Member5(String name, String tel, String address) {
		System.out.println("�Ķ���� 3���� ���� ������ ȣ���");
		this.name = name;
		this.tel = tel;
		this.address = address;
	}
	
	void print() {
		System.out.println("name : " + name);
		System.out.println("tel : " + tel);	
		System.out.println("address : " + address);
	}	
}
