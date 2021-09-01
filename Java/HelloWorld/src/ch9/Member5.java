package ch9;

public class Member5 {
	String name;
	String tel;
	String address;
	
	Member5() {
		this("no name");
		System.out.println("파라미터에 없는 생성자의 this() 후");
	}
	
	Member5(String name) {
		this("test", "222", "뉴욕");
		System.out.println("파라미터 1개를 갖는 생성자의 this() 후");
		System.out.println("전달 받은 파라메터 : " + name);
	}
	
	Member5(String name, String tel, String address) {
		System.out.println("파라미터 3개를 갖는 생성자 호출됨");
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
