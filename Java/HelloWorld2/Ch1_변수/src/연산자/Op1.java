package 연산자;


//사칙연산자 : +, -, *, /, %
//출력문 3가지
//print(누적용이), println(줄바꿈), printf()
public class Op1 {
	public static void main(String[] args) {
		
		int n1 = 33;
		int n2 = 20;
		int result;

		result = n1 + n2;
		System.out.println("n1+n2= " + (n1+n2));
		System.out.print("여기\n");
		System.out.println("저기");
		System.out.printf("%d+%d=%d\n", n1, n2, result); //%d정수, %f 실수, %c문자, %s문자열
		
		result = n1 * n2;
		System.out.printf("%d*%d=%d\n", n1, n2, result);
		
		//int = int/int
		float result2 = n1 / (float)n2;
		System.out.println("n1/n2=" + result2);
		
		result = n1%n2;
		System.out.println("n1%n2=" + result);
	}
}
