package 상속;

class Person{
	private String name;
	private int age;
	
	//생성자
	public Person(){}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	//메소드 : get~(), set~()
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	
	//추가
	public void print() {
		System.out.println("***********");
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
	}
	
}
class Student extends Person {
	
	private String sno;
	
	public Student(String name, int age, String sno) {
		super(name,age);
		this.sno = sno;
	}
	public String getSno() {
		return sno;
	}
	public void setSno() {
		this.sno = sno;
	}
	public void print() {
		super.print();
		System.out.println("학번 : " + sno);
	}
}

class Teacher extends Person{
	
	private String subject;
	public Teacher(String name, int age, String subject) {
		super(name,age);
		this.subject = subject;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject() {
		this.subject = subject;
	}
	public void print() {
		super.print();
		System.out.println("과목 : " + subject);
	}
}

public class E4_Overriding {
	public static void main(String[] args) {
		Person p = new Person();
		//String n = p.name; //private 접근지정자로 인해 접근불가
		//int a = p.age		// 상동 
		p.setName("홍길동");
		String n = p.getName();
		System.out.println("이름 : " + n);
		
		
		//업캐스팅해서 오버라이딩호출활용
		Person [] ps = new Person[2];	// ps -->> [주소] [주소]
		//											 |     |
		//										   ps[0]  ps[1]
		//										    속성   속성
		//									 	  메소드()  메소드()
		
		ps[0] = new Student("수지" ,22, "1111");   //업캐스팅
		ps[1] = new Teacher("선생" ,30, "수학");   //업캐스팅
		
		//출력
		for(Person person: ps) {
			
			if(person instanceof Student) {
				Student st = (Student)person;
				st.print();
			}else if(person instanceof Teacher){
				Teacher t = (Teacher)person;
				p.print();
			}
			
		}
		
		
	}
}
