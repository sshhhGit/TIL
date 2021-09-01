package ch12;

public class SuperConMain {

	public static void main(String[] args) {
		SuperConChild scc = new SuperConChild(1, 2, 3);
		//6번, 하위클래스에서 SuperConChild의 객체를 생성하는데,
		//생성자의 파라미터를 넣어 호출
		scc.print();
	}
}
