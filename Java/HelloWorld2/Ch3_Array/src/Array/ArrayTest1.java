package Array;

public class ArrayTest1 {

	public static void main(String[] args) {
		String a;
		String b;
		String c;
		String d;
		String e;
		
		//배열은 여러개의 변수를 연속공간에 모아놓은 것이다.
		
		// 배열생성
		// 데이터타입	name --->[a][b][c][d][e]
		//				  0  1  2  3  4
		// 배열값넣기		 name[0] = 100; 
		//				 name[1] = 50; 
		//				 name[2] = 80; 
		//				 name[3] = 90; 
		//				 name[4] = 150; 
		
		// 생성방법들
		// 데이터타입 [] 배열명 = new 데이터타입[방의개수];
		// 데이터타입 [] 배열명 = new 데이터타입[]{값1, 값2, ....};
		// 데이터타입 [] 배열명 = {값1, 값2, 값3 .....};
		
		// 여러종류 배열 생성
		
		int[] num = new int[3];	// 정수를 저장할 수 있는 배열방3개짜리 num을 만드세요 
								// num --- > [][][]
		num[0]=10;
		num[1]=20;
		num[2]=30;
		num[3]=40;
		
		System.out.println(num[0]);
		System.out.println(num[1]);
		System.out.println(num[2]);
		System.out.println(num[3]);
	}

}
