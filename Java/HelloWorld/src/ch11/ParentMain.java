package ch11;

public class ParentMain {
	
	public static void main(String[] args) {
		Parent p = new Parent(); //��ü�� �����Ǹ� �ٷ� �����ڰ� ȣ��Ǿ�
		p.name = "�θ�"; 		//�޼����� ���
		p.age = 50;
		p.setMoney(1000000);
		p.printParentInfo();
		System.out.println("money : " + p.getMoney());
		System.out.println("--------------");
		
		Child c = new Child(); //child��ü�� �����Ǳ� ������
		c.name = "�ڽ�";			//parent ��ü�� �ڵ����� ����.
		c.age = 200;			//�ڿ��� ��ġ�� ����.
		c.setHobby("��Ÿ");
		c.printParentInfo();
		c.printInfo();
	}
}
