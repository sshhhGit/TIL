package ch4;

public class For6 {
	public static void main(String[] args) {
		int i, j;
		for(i=0;i<10;i++) {
			for(j=2;j<10;j++) {
				if(i==0) {
					System.out.print(j+"´Ü\t");
				}else{
					System.out.print(j+"*"+i+"="+(j*i+"\t"));
				}
				
			}
			System.out.println();
		}
	}

}
