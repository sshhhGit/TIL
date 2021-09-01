package ch8;

public class ParaMain {

		public static void main(String[] args) {
			
			Add a = new Add(); //클래스 Add의 객체 a를 생성.
			
			int result_int;
			float result_float, x = 3.2f, y = 8.5f;
			String result_string;
			
			result_int = a.add_int(3, 5);
			System.out.println("result of int = " + result_int);
			
			result_float = a.add_float(x, y);
			System.out.println("result of float = " + result_float);
			
			result_string = a.add_string("aaa", "bbb");
			System.out.println("result of string = " + result_string);
		}
}
