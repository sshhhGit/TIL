package ch10;

public class MemberMain {
	
	public static void main(String[] args) {
		Member m = new Member();
		
		m.setName("김병만"); // m.name="김병만";
		m.setTel("5555"); // m.tel="5555";
		m.setAddress("서울시"); //m.address="서울시";
		//8~10번 줄은 각 멤버의 setter를 호출해서 private 멤버변수 값 할당/
		
		String name = m.getName(); //m.name
		String tel = m.getTel(); //m.tel
		String address = m.getAddress(); //m.address
		//13~15번 줄은 멤버의 getter를 호출해서 private 멤버변수의 값을 읽는다.
		
		System.out.println("name : " + name);
		System.out.println("tel : " + tel);
		System.out.println("address : " + address);
	}

}
