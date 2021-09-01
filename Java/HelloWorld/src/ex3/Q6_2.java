package ex3;

public class Q6_2 {
	public static void main(String[] args) {
		int[] num = {10, 20, 30, 40, 50};
			for(int i=0; i<num.length; i++) 
				num[i] = 5-i;
			
			for(int i=0; i<num.length; i++) 
				System.out.println("num[" + i + "] = " + num[i]+", ");
			
	}
}
