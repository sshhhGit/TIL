package 제네릭1;

class GStack2 {
	int point;
	Object[] stack;
	
	//생성자
	public GStack2() {
		point = 0;
		stack = new Object[10];
	}
	void push(Integer item) {
		if(point == 10) {
			return;
		}
		stack[point] = item;
		point ++;
	}
	Integer pop() {
		
		if(point == 0) {
			return null;
		}
		point --;
		return (Integer) stack[point]; 
	}
}

public class Generic3_Integer {
	public static void main(String []args) {
		
		GStack2 st = new GStack2();
		st.push(100);
		st.push(200);
		st.push(300);
		st.push(400);
		st.push(500);
		
		for(int i = 0; i < 5; i++) {
			System.out.println(st.pop());
		}
	}
}
