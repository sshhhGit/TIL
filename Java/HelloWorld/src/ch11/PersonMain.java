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
		f.setName("����1");
		f.setDept("��ǻ�Ͱ��а�");
		f.setAddress("�����");
		f.setSubjects(new String[] { "�����а���", "C ���α׷���", "RTOS"});
		f.print();
		f.print_subj();
		System.out.println("------------");
		
		Student s = new Student();
		s.setNum(3);
		s.setName("�л�1");
		s.setDept("��ǻ�Ͱ��а�");
		s.setAddress("��⵵");
		s.setSubjects(new String[] { "�ڹ� ���α׷���", "�ü��", "�����Ϸ�"});
		s.print();
		s.print_subj();
		System.out.println("------------");
		
		Staff sf = new Staff();
		sf.setNum(4);
		sf.setName("����1");
		sf.setDept("HR");
		sf.setAddress("������");
		sf.setJob("������");
		sf.print();
		sf.print_job();
	}
}
