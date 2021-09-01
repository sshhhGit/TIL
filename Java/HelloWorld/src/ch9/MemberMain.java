package ch9;

public class MemberMain {

		public static void main(String[] args) {
			Member m = new Member(); //객체 생성시 생성자 호출.
			m.print(); //생성자가 실행되면 멤버들은 할당한 값으로 초기화.
			m.setMemberData("류현진", "010-1111-2222", "로스앤젤레스");
			m.print();
		}
}
