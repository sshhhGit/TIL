package ch9;

public class Member3 {
	String name;
	String tel;
	String address;
	
	Member3(String name, String tel, String address) {
		this.name = name; //this.��������� ����Ͽ� ������ �̸���
		this.tel = tel;   //��������� ���� ������ ����.
		this.address = address; 
	}
	
	void print() {
		System.out.println("name : " + name);
		System.out.println("tel : " + tel);
		System.out.println("address : " + address);
	}
}
//this.name = name;
//�º��� ��� ���� name, �캯�� �������� name.
