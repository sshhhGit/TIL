package ch10;

public class MemberMain {
	
	public static void main(String[] args) {
		Member m = new Member();
		
		m.setName("�躴��"); // m.name="�躴��";
		m.setTel("5555"); // m.tel="5555";
		m.setAddress("�����"); //m.address="�����";
		//8~10�� ���� �� ����� setter�� ȣ���ؼ� private ������� �� �Ҵ�/
		
		String name = m.getName(); //m.name
		String tel = m.getTel(); //m.tel
		String address = m.getAddress(); //m.address
		//13~15�� ���� ����� getter�� ȣ���ؼ� private ��������� ���� �д´�.
		
		System.out.println("name : " + name);
		System.out.println("tel : " + tel);
		System.out.println("address : " + address);
	}

}
