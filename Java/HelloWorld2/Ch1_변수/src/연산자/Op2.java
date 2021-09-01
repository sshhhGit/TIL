package 연산자;


//증감연산자
public class Op2 {
	public static void main(String[] args) {
		
		
		//연산자가 앞에 있을땐 더하고 연산
		//연산자가 뒤에 있을떈 연산하고 증감
		int a = 2;
		int c = 1;
		c = (a++)+c;
		
		System.out.println(c);
		System.out.println(a);
		
		a++; //a = a+1
		a--; //a = a-1
		
		++a; 
		--a;
		
	}
}
