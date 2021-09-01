//문제 7-2
//3개의 int형 인수 a, b, c 중 최솟값을 구하는 min 메서드를 작성하자.
//int min(int a, int b, int c)
package ex3;

//3개의 정숫값에서 최솟값 구하기
import java.util.Scanner;

public class Q7_2 {
	//-- a, b, c의 최솟값 반환--//
	static int min(int a, int b, int c) {
		int min = a;
		if (b < min) min = b;
		if (c < min) min = c;
		return min;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("정수 a: "); int a = stdIn.nextInt();
		System.out.print("정수 b: "); int b = stdIn.nextInt();
		System.out.print("정수 c: "); int c = stdIn.nextInt();
		System.out.print("최솟값은 " + min(a, b, c) + "입니다.");
		

	}
}