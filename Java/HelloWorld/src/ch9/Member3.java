package ch9;

public class Member3 {
	String name;
	String tel;
	String address;
	
	Member3(String name, String tel, String address) {
		this.name = name; //this.멤버변수를 사용하여 동일한 이름의
		this.tel = tel;   //멤버변수와 지역 변수를 구분.
		this.address = address; 
	}
	
	void print() {
		System.out.println("name : " + name);
		System.out.println("tel : " + tel);
		System.out.println("address : " + address);
	}
}
//this.name = name;
//좌변은 멤버 변수 name, 우변은 지역변수 name.
