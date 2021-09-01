package Cls;
/* Object클래스 java.lang
 
  		equals(객체)
  		getClass()
  		hashCode()
  		toString()
  		notify()      스레드(Thread)
  		notifyAll()	  스레드	
  		wait()		  스레드
  		
  		
 */
class Point {
	int x, y;
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	
	}
	public String toString() {
		return "Point("+x+", "+y+")";
	}
}
public class Object1 {
	public static void main(String []args) {
		Point a = new Point(2,3);
		
		System.out.println(a.toString());
		System.out.println(a);
	}
}
