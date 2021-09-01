package ch11;

public class Child extends Parent { //child의 멤버변수는 hobby뿐 아니라
	private String hobby; //상속받은 name, age도 사용.
	
	public Child() { //생성자
		System.out.println("Child 생성자");
	}
	
	public void printInfo() {
		System.out.println("name : " + name);
		System.out.println("age : " + age);
//		System.out.println("money : " + money); 에러발생
//		money를 출력하지만 private멤버는 자식클래스에 상속되지 않는다.
		System.out.println("hobby : " + hobby);
	}
	
	public String getHobby() { //hobby의 getter.
		return hobby;
	}
	
	public void setHobby(String hobby) { //hobby의 setter.
		this.hobby = hobby;
	}

}
