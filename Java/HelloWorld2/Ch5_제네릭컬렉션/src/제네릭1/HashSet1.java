package 제네릭1;

import java.util.HashSet;
import java.util.Iterator;

public class HashSet1 {
	public static void main(String [] args) {
		
		HashSet<String> hs = new HashSet<>();
		
		hs.add("임꺽정");
		hs.add("홍길동");
		hs.add("이순신");
		hs.add("홍길동");
		hs.add("임꺽정");
		
		for(String name: hs) {
			System.out.println(name);
		}
		System.out.println("사이즈: " + hs.size());
		
		Iterator<String>it = hs.iterator();
		while(it.hasNext()) {
			String name = it.next();
			System.out.println(name);
		}
	}
}
