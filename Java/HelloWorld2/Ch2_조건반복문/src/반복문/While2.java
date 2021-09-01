package 반복문;

public class While2 {
	public static void main(String[] args) {
		
		System.out.println("구구단을 출력합니다.");
		
		int i = 1, j =1;
		
		while(i<=9) {			//1
			
			while(j<=9) {		//1 2 3 4 5 6 7 8 9 1 2 3
				System.out.println(i+"*"+j+"="+(i*j)+" ");
				j++;
			}
			System.out.println();
			j=1;
			i++;
		}
	}
}
