package ch11;

public class PersonMain {
	
	public static void main(String[] args) {
		Person p = new Person();
		p.setNum(1);
		p.setName("person");
		p.setDept("dept");
		p.setAddress("address");
		p.print();
		System.out.println("------------");
		
		Professor f = new Professor();
		f.setNum(2);
		f.setName("교수1");
		f.setDept("컴퓨터공학과");
		f.setAddress("서울시");
		f.setSubjects(new String[] { "전산학개론", "C 프로그래밍", "RTOS"});
		f.print();
		f.print_subj();
		System.out.println("------------");
		
		Student s = new Student();
		s.setNum(3);
		s.setName("학생1");
		s.setDept("컴퓨터공학과");
		s.setAddress("경기도");
		s.setSubjects(new String[] { "자바 프로그래밍", "운영체제", "컴파일러"});
		s.print();
		s.print_subj();
		System.out.println("------------");
		
		Staff sf = new Staff();
		sf.setNum(4);
		sf.setName("교원1");
		sf.setDept("HR");
		sf.setAddress("강원도");
		sf.setJob("교육부");
		sf.print();
		sf.print_job();
	}
}
