package 제네릭1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class HashMap1 {
	public static void main(String[]args) {
		
		HashMap<Integer, String> hm = new HashMap<>();
		
		hm.put(1,"우리나라");
		hm.put(2,"좋은나라");
		hm.put(3,"대한민국");
		hm.put(4,"우리나라");
		hm.put(4,"대한민국");
		
		hm.remove(4);
		
		System.out.println(hm.get(1));
		System.out.println(hm.get(4));
		System.out.println(hm.size());
		
		for(int i = 0; i < hm.size(); i++) {
			System.out.println(hm.get(i));
		}
		
		
		Set<Integer> keys = hm.keySet();
		Iterator<Integer> it = keys.iterator();
		while(it.hasNext()) {
			int key = it.next();
			String str = hm.get(key);
			System.out.println(str);
		}
		//***************************************
		HashMap<Integer, Student> student = new HashMap<>();
		student.put(0001, new Student("홍길동", 30));
		student.put(0002, new Student("강감찬", 31));
		student.put(0003, new Student("이순신", 32));
		student.put(0004, new Student("을지문덕", 33));
		
		Set<Integer> ks = student.keySet();
		Iterator<Integer> its = ks.iterator();
		while(its.hasNext()) {
			int num = its.next();
			Student st = student.get(num);
			System.out.println(st.getName());
			System.out.println(st.getAge());
			System.out.println("***************");
		}
		
		
	}
}
