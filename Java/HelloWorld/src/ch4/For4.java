package ch4;

public class For4 {
	public static void main(String[] args) {
		int i, j;
		//������ 2~9�� ���
		for(i=2;i<10;i++) {
			for(j=1;j<10;j++) {
				System.out.print(i+"*"+j+"="+i*j+"\t");
				if(j==9) {
					System.out.println();
				}
			}
		
		}
	
	}

}
