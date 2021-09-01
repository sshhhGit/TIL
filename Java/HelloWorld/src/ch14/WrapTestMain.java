package ch14;

public class WrapTestMain {
	public static void main(String[] args) {
		WrapTest t = new WrapTest();
		
		t.add(new Interger(10));
		t.add(new Interger(25));
		t.add(new Interger(3.56f));
		t.add(new Interger(56.123f));
		t.print;
		System.out.println();
		
		String str1 = "123";
		String str2 = "456";
		int x = Integer.parseInt(str1);
		int y = Integer.parseInt(str2);
		System.out.println("문자열 의 합:" + str1 + str2);
		System.out.println("숫자의 합:" + (x+y));
	}
}
