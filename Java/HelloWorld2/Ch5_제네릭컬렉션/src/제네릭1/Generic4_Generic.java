package 제네릭1;

class GStack3 <T>{
	int point;
	Object[] stack;
	
	//생성자
	public GStack3() {
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

public class Generic4_Generic {
	public static void main(String []args) {
		GStack3 <Integer> st1 = new GStack3<Integer>();
		st1.push(100);
		st1.push(200);
		st1.push(300);
		st1.push(400);
		st1.push(500);
		st1.push(600);
		st1.push(700);
		st1.push(800);
		st1.push(900);
		
		for(int i = 0; i < 9; i++) {
			System.out.println(st1.pop());
		}
		
		GStack3 <String> st2 = new GStack3();
		st2.push("서울");
		st2.push("부산");
		st2.push("광주");
		st2.push("대구");
		st2.push("대전");
		st2.push("인천");
		
		for(int i = 0; i < 6; i++) {
			System.out.println(st2.pop());
		}
		
		GStack3 <Float> st3 = new GStack3<>();
		st3.push(100.1f);
		st3.push(200.2f);
		st3.push(300.3f);
		st3.push(400.4f);
		st3.push(500.5f);
		st3.push(600.5f);
		
		for(int i = 0; i<6; i++) {
			System.out.println(st3.pop());
		}
	}
}
