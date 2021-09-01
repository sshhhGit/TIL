package Array;

public class Array2 {
	public static void main(String [] args) {
		int[] a = new int [5];
		a[0]= 85;
		a[1]= 90;
		a[2]= 75;
		a[3]= 100;
		a[4]= 95;
		
		int sum=0;
		double avg;
		
		for(int i=0; i<a.length; i++) {
			sum += a[i];
		}
		
		avg = sum/a.length;
		System.out.println("합계: " + sum);
		System.out.println("과목수: " + a.length);
		System.out.println("평균: " + avg);
	}
}
