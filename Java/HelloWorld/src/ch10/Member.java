package ch10;

public class Member {
	
	private String name; //����� ��� private, ���� Ŭ������ ���������
	private String tel; //private���� ������ �ܺη� ������ ����
	private String address; //�����Ǵ� ���� ���´�.
	
	public void printMember() { //publicŬ���� �ۿ��� ȣ���� �� �ִ�.
		System.out.println("name : " + name);
		System.out.println("tel : " + tel);
		System.out.println("address : " + address);
	}
	
	public String getName() { //������� name�� getter��
		return name;		  //Ŭ���� �ۿ��� name�� ���� ������ ȣ��.
	}
	
	public void setName(String name) { //������� name�� setter��
		this.name = name; //Ŭ���� �ۿ��� �־��� �Ķ��Ÿ ���� name�� �Ҵ�
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
