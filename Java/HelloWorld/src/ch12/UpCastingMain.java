package ch12;

public class UpCastingMain {
	
	public static void main(String[] args) {
		 System.out.println("UpCastingParent의 객체");
		 UpCastingParent up = new UpCastingParent();
		 System.out.println("up.add()=" + up.add() + "\n");
		 
		 System.out.println("UpCastingChild 객체");
		 UpCastingChild uc = new UpCastingChild();
		 System.out.println("uc.add()=" + uc.add());
		 System.out.println("uc.sub()=" + uc.sub() + "\n");
		 
		 System.out.println("UpCasting된 객체");
		 UpCastingParent upc = new UpCastingChild();
//		 업캐스팅 객체를 생성, 타입은 부모클래스인 UpCastingParent이고
//		 생성자 호출은 자식클래스인 UpCastingChild의 것을 호출.
		 System.out.println("upc.add()=" + upc.add() + "\n");
//		 System.out.println("upc.sub()="+upc.sub());
//		 //sub()호출하는데, upc의 타입이 UpCasintParent이므로
//		 이클래스에는 sub()이 정의되지 않았다. 그래서 에러발생
//		 이처럼 타입은 부모, 실행되는 형태는 자식인걸을 업캐스팅이라고함
	}
}
