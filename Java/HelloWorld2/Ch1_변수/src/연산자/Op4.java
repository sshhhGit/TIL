package 연산자;

//비트연산자
public class Op4 {
	public static void main(String[] args) {
						//16  8	  4	  2	  1
		int n1 = 10;	//0   1   0   1   0
		int n2 = 5;		//0   0   1   0   1
	//--------------------------------------
	//		&(AND)		//0   0   0   0   0
		System.out.println(n1&n2);
		
	//--------------------------------------
	//		|(OR)		//0   1   1   1   1
		System.out.println(n1|n2);
		
	}

}
