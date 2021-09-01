package Array;

public class ArrayTest {

	public static void main(String[] args) {
		String a;
		String b;
		String c;
		String d;
		String e;
		
		//배열은 여러개의 같은타입 변수를 연속공간에 모아놓은 것이다.
		
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
		//num[3]=40; //인덱스를 넘어서서 값을 넣을수도 없다
		
		System.out.println(num[0]);
		System.out.println(num[1]);
		System.out.println(num[2]);
		//System.out.println(num[3]); //인덱스를 넘어서서 값을 출력 할 수도 없다
		
		System.out.println("*************");
		
		//입력
		for(int i = 0; i<num.length; i++) {
			num[i]=10*i;
		}
		
		//출력1 - 전체
		for(int i = 0; i < num.length; i++) {
			System.out.println(num[i]);
		}
		
		//출력2 - 전체(확장for)
		for(int k: num) {
			System.out.println(k);
		}
		//========두번쨰 학습=========
		
		String [] str;
		str = new String[] {"한라산", "백두산", "금강산"};
		
		//전체출력 - 방법1(실습)
		//전체출력 - 방법2(실습)
		
		//========세번쨰 학습=========
		double [] avg = {89.4, 93.5, 70.5}; // 별도로 나누어 초기화 할 수 없다
		
		//미션
		/*
		 
		 * ① Scanner로 값을 10개 입력받는다.
		 * ② 입력받은 값을 배열에 넣는다.
		 * ③ 배열속의 값을 오름차순으로 정렬해서 다시 넣는다.
		 * ④ 전체를 두가지 방식으로 출력해 본다.
		 */
		
		
		
				
		
	}

}
