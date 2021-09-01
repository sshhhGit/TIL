package Array;
/*
 * 	이차원 배열
 * 		int[][]arr = new [2][3];	
 * 						[0,0][0,1][0,2] 
 * 						[1,0][1,1][1,2] 
 * 
 * 
 * 		arr[0][0] = 10;   [10][20][30]
 * 		arr[0][1] = 20;
 * 		arr[0][2] = 30;
 * 
 * 		arr[1][0] = 40;	  [40][50][60]
 * 		arr[1][1] = 50;
 * 		arr[1][2] = 60;
 * 
 */
public class Array4 {
	public static void main(String[] args) {
		
		int[][] a =new int[2][3];
		
		a[0][0]=7;	a[0][1]=23; a[0][2]=11;
		a[1][0]=27; a[1][1]=2;	a[1][2]=23;
		
		//출력
		for(int i =0; i<a.length; i++) {
			for(int k=0; k<a[i].length; k++) {
				
				System.out.print(a[i][k]+" ");
			}
			System.out.println();
		}
		
		//출력
		for(int[] i: a) {
			for(int j: i) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
}
