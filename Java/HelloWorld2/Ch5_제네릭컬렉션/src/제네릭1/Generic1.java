package 제네릭1;

class Queue <T> {
	/*
	//push
	Integer[] push(Integer[] data) {
		for(int i = 0; i < data.length; i++) {
			data[i] = Integer.valueOf(i);
		}
		return data;
	}
	///pop
	void pop(Integer[] data) {
		for(int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}
*/
//push
	/*Float[] push(Float[] data) {
		for(int i = 0; i < data.length; i++) {
			data[i] = Float.valueOf(i);
		}
		return data;
	}
	///pop
	void pop(Float[] data) {
		for(int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}
	*/
	/*
	Character[] push(Character[] data) {
	for(int i = 0; i < data.length; i++) {
		data[i] = ((char)(i + 97));
	}
	return data;
}
///pop
void pop(Character[] data) {
	for(int i = 0; i < data.length; i++) {
		System.out.println(data[i]);
	}
}
*/
T[] push(T[] data) {
for(int i = 0; i < data.length; i++) {
	data[i] = (T)("번따클럽" + i);
}
return data;
}
///pop
void pop(T[] data) {
for(int i = 0; i < data.length; i++) {
	System.out.println(data[i]);
}
}
}

public class Generic1 {
	public static void main(String [] args) {
		/*Integer[] push(Integer[] data) {
			for(int i = 0; i < data.length; i++) {
				data[i] = Integer.valueOf(i);
			*/
		/*Float[] data2 = new Float[10];
		
		Queue queue1 = new Queue();
		queue1.push(data2);
		queue1.pop(data2);
		*/
		String[] data5 = new String[10];
		
		//구체화
		Queue <String> queue5= new Queue<>();
		
		queue5.push(data5);
		queue5.pop(data5);
		
	}
}
