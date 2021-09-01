package ch9;

public class Member {
	String name;
	String tel;
	String address;
	
	Member() {
			name = "no name";
			tel = "no tel";
			address = "no address";
	}
	void setMemberData(String _name, String _tel, String _address) {
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
