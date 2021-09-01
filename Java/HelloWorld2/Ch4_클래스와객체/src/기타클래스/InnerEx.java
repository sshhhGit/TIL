package 기타클래스;

class Out {
	
	//멤버변수
	//생성자
	//메소드
	
	String name = "개똥이";
	void outPrint() {
		System.out.println("외부메소드");
	}
	
	class inner{
		int age = 10;
		void innerPrint() {
			System.out.println("내부 메소드 입니다.");
		}
	}
}

public class InnerEx {
	public static void main(String[] args) {
		
		Out out = new Out();
		System.out.println(out.name);
		out.outPrint();
		
		System.out.println("************");
		Out.inner oi = out.new inner();
		System.out.println(oi.age);
		oi.innerPrint();
	}
}

