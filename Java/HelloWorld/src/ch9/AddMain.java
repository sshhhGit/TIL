package ch9;

public class AddMain {
	
	public static void main(String[] args) {
		Add a = new Add();
		System.out.println("int�� param 2���� add()ȣ�� : " + a.add(3, 5));
		System.out.println("int�� param 3���� add()ȣ�� : " + a.add(3, 4, 5));
		System.out.println("float�� add()ȣ�� : " + a.add(3.4f, 4.7f));
		System.out.println("String�� add()ȣ�� : " + a.add("aaa", "bbb"));
	}
	
	
}
