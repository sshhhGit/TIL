package Cls;


public class Object2 {
	public static void main(String[] args) {
		
		Point p = new Point(2, 3);
		
		System.out.println(p.getClass().getName());
		System.out.println(p.hashCode());
		System.out.println(p.toString());
		System.out.println(p);
	}
}
