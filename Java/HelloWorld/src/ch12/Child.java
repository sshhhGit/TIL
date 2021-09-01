package ch12;

public class Child extends Parent {  
	private String hobby;
	
	@Override 
	public void printInfo() {
		System.out.println("name : " + name);
		System.out.println("hobby : " + hobby);
	}
	
	public String getHobby() {
		return hobby;
	}
	
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
}
