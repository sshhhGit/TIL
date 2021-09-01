package ch10;

public class Member {
	
	private String name; //멤버는 모두 private, 보통 클래스의 멤버변수는
	private String tel; //private으로 지정해 외부로 정보가 직접
	private String address; //공개되는 것을 막는다.
	
	public void printMember() { //public클래스 밖에서 호출할 수 있다.
		System.out.println("name : " + name);
		System.out.println("tel : " + tel);
		System.out.println("address : " + address);
	}
	
	public String getName() { //멤버변수 name의 getter로
		return name;		  //클래스 밖에서 name의 값을 읽을때 호출.
	}
	
	public void setName(String name) { //멤버변수 name의 setter로
		this.name = name; //클래스 밖에서 넣어준 파라미타 값을 name에 할당
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
}
