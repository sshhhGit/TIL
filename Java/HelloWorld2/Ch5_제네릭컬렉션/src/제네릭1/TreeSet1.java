package 제네릭1;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSet1 {
	public static void main(String [] args) {
		
		TreeSet<String> tr = new TreeSet();
		
		tr.add("가");
		tr.add("라");
		tr.add("다");
		tr.add("나");
		tr.add("나");
		tr.add("가");
		tr.add("나");
		
		Iterator<String> it= tr.iterator();
		while(it.hasNext()) {
			String name = it.next();
			System.out.println(name);
		}
	}
}
