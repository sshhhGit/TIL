package ch11;

public class Person {
	protected int num; //멤버변수를 선언한 코드로 접근제어를 protected
	protected String name;
	protected String dept;
	protected String address;
	
	public void print() {
		System.out.println("num : " + num);
		System.out.println("name : " + name);
		System.out.println("dept : " + dept);
		System.out.println("address : " + address);
	}
	
	public int getNum() { //16~46줄은 상속관계가 아닌 다른 클래스가
		return num; //멤버변수에 접근 할 수 있도록 setter와 getter를 정의
	}
	
	public void setNum(int num) {
		this.num = num;		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDept() {
		return dept;
	}
	
	public void setDept(String dept) {
		this.dept = dept;		
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;		
	}
}
