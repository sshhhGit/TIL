package ch11;

public class ParentMain {
	
	public static void main(String[] args) {
		Parent p = new Parent(); //객체가 생성되면 바로 생성자가 호출되어
		p.name = "부모"; 		//메세지를 출력
		p.age = 50;
		p.setMoney(1000000);
		p.printParentInfo();
		System.out.println("money : " + p.getMoney());
		System.out.println("--------------");
		
		Child c = new Child(); //child객체가 생성되기 이전에
		c.name = "자식";			//parent 객체가 자동으로 생성.
		c.age = 200;			//자연의 이치와 같음.
		c.setHobby("기타");
		c.printParentInfo();
		c.printInfo();
	}
}
