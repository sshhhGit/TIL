package 제네릭1;

import java.util.Vector;

public class Vector1 {
	public static void main(String [] args) {
		
		Vector<Integer> v = new Vector<>();
		
		v.add(5);
		v.add(10);
		v.add(-4);
		v.add(276);
		
		v.add(2,1000);
		v.add(5,2000);
		
		Integer value = v.get(0);
		int val = value.intValue();
		int num = v.get(0);
		
		System.out.println("언박싱: " + val);
		System.out.println("자동언박싱: " + num);
		System.out.println("벡터사이즈: " + v.size());
		System.out.println("벡터크기: " + v.capacity());
		System.out.println("마지막요소: " + v.lastElement());
		
		v.remove(0);
		System.out.println("지워진 첫번째 값이 있나요?:"+ v.get(0));
		
		v.clear();
		System.out.println("다 지워졌나요?: " + v.isEmpty());
	}
}
