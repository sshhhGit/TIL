package 제네릭1;

class GStack1 {
	int point;
	Object[] stack;
	
	//생성자
	public GStack1() {
		point = 0;
		stack = new Object[10];
	}
	void push(String item) {
		if(point == 10) {
			return;
		}
		stack[point] = item;
		point ++;
	}
	String pop() {
		
		if(point == 0) {
			return null;
		}
		point --;
		return (String) stack[point]; 
	}
}

 
public class Generic2_String {
	public static void main(String []args) {
		
		GStack1 st = new GStack1();
		st.push("서울");
		st.push("부산");
		st.push("광주");
		st.push("서울");
		st.push("부산");
		st.push("광주");
		
		for(int n = 0; n < 6; n++) {
			System.out.println(st.pop());
		}
		
		
	}
}








