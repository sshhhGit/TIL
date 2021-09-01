package 제네릭1;

class GStack4 <T>{
	int point;
	Object[] stack;
	
	//생성자
	public GStack4() {
		point = 0;
		stack = new Object[10];
	}
	void push(T item) {
		if(point == 10) {
			return;
		}
		stack[point] = item;
		point ++;
	}
	T pop() {
		
		if(point == 0) {
			return null;
		}
		point --;
		return (T) stack[point]; 
	}
}

public class Generic6 {
	
	public static <T> GStack4<T> reverse(GStack4<T> a){
		
		GStack4<T> s = new GStack4<T>();
		while(true) {
			
			T tmp = a.pop();
			if(tmp == null) {
				break;
			}else {
				s.push(tmp);
			}
		}
		return s;
	}
	
	public static void main(String [] args) {
		
		GStack4 <Double> gs = new GStack4();
		for(int i = 0; i < 5; i++) {
			gs.push(new Double(i));
		}
		
		 gs = reverse(gs);
		 for(int i = 0; i < 5; i++) {
			 System.out.println(gs.pop());
		 }
	}
}











