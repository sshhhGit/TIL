package ch8;

public class LocalVarMain {
	
	public static void main(String[] args) {
		LocalVar lv = new LocalVar();
		lv.localTest();
//		System.out.println("a = " + a + ", b = " + b); 에러발생
		lv.printVar();
		lv.memVar = 500;
		lv.printVar();
	}
}
