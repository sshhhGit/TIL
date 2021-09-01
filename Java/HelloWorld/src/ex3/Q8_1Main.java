package ex3;

public class Q8_1Main {
	public static void main(String[] args) {
		Q8_1 human = new Q8_1("홍길동", 180, 73);
		
		System.out.println("이름 : " + human.name);
		System.out.println("키 : " + human.height + "cm");
		System.out.println("체중 : " + human.weight + "kg");
	}
}
