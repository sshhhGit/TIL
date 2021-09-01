package ch9;

public class Member2 {
	String name;
	String tel;
	String address;
	
	Member2() { //持失切
		name = "no name";
		tel = "no tel";
		address = "no address";
	}
	
	Member2(String _name) { //持失切
		name = _name;
		tel = "no tel";
		address = "no address";
	}
	
	Member2(String _name, String _tel) { //持失切
		name = _name;
		tel = _tel;
		address = "no address";
	}
	
	Member2(String _name, String _tel, String _address) { //持失切
		name = _name;
		tel = _tel;
		address = _address;
	}
	
	void print() {
		System.out.println("name : " + name);
		System.out.println("tel : " + tel);
		System.out.println("address : " + address);
	}
}
