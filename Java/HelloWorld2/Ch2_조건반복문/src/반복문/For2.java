package 반복문;

public class For2 {
	public static void main(String[]args) {
		
		for(int i = 1; i<=9; i++) {       //1 
			
			for(int j=1; j<=9; j++) {	  //1 2 3 4 5 6 7 8 9 1 2
				System.out.println(i+"*" +j + "=" +(i*j));
			}
			System.out.println(); //한줄 띄우기
		}
	}
}
