package ch11;

public class Student extends Person {
	private String[] subjects;
	
	public void print_subj() {
		System.out.println(name + " 학생의 수강신청 과목");
		for(int i = 0; i < subjects.length; i++) {
			System.out.println("subject : " + subjects[i]);
		}
	}
	
	public String[] getSubjects() {
		return subjects;
	}
	
	public void setSubjects(String[] subjects) {
		this.subjects = subjects;
	}

}
