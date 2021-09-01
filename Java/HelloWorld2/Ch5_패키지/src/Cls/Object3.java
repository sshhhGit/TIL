package Cls;



public class Object3 {
	public static void main(String [] args) {
		
		Point a = new Point(2, 3);
		Point b = new Point(2, 3);
		Point c =a;
		
		if(a.equals(b)) {
			System.out.println("a==b");
		}
		if(a.equals(c)) {
			System.out.println("a==c");
		}
	}
}
