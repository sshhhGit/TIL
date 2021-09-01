package 제네릭1;

import java.util.Vector;
class Student {
	private String name;
	private int age;
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
public class Vector2 {
	public static void main(String [] args) {
		
		Vector<Student> student = new Vector<>();
		
		student.add(new Student("홍길동", 30));
		student.add(new Student("이순신", 40));
		student.add(new Student("강감찬", 40));
		
		Student st1 = student.get(0);
		System.out.println(st1.getName());
		System.out.println(st1.getAge());
		
		for(int i = 0; i < student.size(); i++) {
			Student st = student.get(i);
			System.out.println("이름: " + st.getName());
			System.out.println("나이: " + st.getAge());
			System.out.println("**************");
		}
	}
}
