package ch11;

public class Staff extends Person {
	private String job;
	
	public void print_job() {
		System.out.println(name + " ������ ������ " + job);
	}
	
	public String getJob() {
		return job;
	}
	
	public void setJob(String job) {
		this.job = job;
	}

}
