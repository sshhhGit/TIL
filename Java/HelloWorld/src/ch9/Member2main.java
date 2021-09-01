package ch9;

public class Member2main {

		public static void main(String[] args) {
			Member2 m1 = new Member2();
			m1.print();
			Member2 m2 = new Member2("¾ÆÀÌÀ¯");
			m2.print();
			Member2 m3 = new Member2("È«±æµ¿", "010-1245-1234");
			m3.print();
			Member2 m4 = new Member2("±è¸»¼÷", "010-9999-8888", "´ëÇÑ¹Î±¹");
			m4.print();
		}
}
