package ch9;

public class AddMain {
	
	public static void main(String[] args) {
		Add a = new Add();
		System.out.println("int형 param 2개의 add()호출 : " + a.add(3, 5));
		System.out.println("int형 param 3개의 add()호출 : " + a.add(3, 4, 5));
		System.out.println("float형 add()호출 : " + a.add(3.4f, 4.7f));
		System.out.println("String형 add()호출 : " + a.add("aaa", "bbb"));
	}
	
	
}
