package 제네릭1;

class Point <T,V> {
	
	T x;
	V y;
	
	Point(T x, V y){
		this.x = x;
		this.y = y;
	}
	T getX() {
		return x;
	}
	V getY() {
		return y;
	}
}

public class Generic7 {
	
	public static <T,V> double makeRect(Point<T,V> p1, Point<T,V>p2) {
		
		double left = ((Number)p1.getX()).doubleValue();
		double right = ((Number)p2.getX()).doubleValue();
		double top = ((Number)p1.getY()).doubleValue();
		double bottom = ((Number)p2.getY()).doubleValue();
		
		double width = right - left;
		double height = bottom - top;
		
		return width * height;
	}
	
	public static void main(String [] args) {
		
		Point <Integer, Double> p1 = new Point(0, 0.0);
		Point <Integer, Double> p2 = new Point(10, 10.2);
		
		System.out.println("면적: " + makeRect(p1, p2));
	}
}
