package ch3;

public class Op2 {
	public static void main(String [] args) {
		int i=5, j;
		j=i++;
		System.out.println("j="+j);
		j=++i;
		System.out.println("j="+j);
		j=i--;
		System.out.println("j="+j);
		j=--i;
		System.out.println("j="+j);
		System.out.println("ÇöÀç i="+i);
		System.out.println("i++ :"+i++);
		System.out.println("++i :"+(++i));
		System.out.println("i-- :"+i--);
		System.out.println("--i :"+(--i));
		
	}

}
