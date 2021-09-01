package ch13;

public abstract class Parent extends GrandParent {
	//두개의 추상메서드를 상속받았기 떄문에 두개 모두를 구현해야 완성된 클래스가 된다.
	@Override //재정의 어노테이션.
	public void print() {
		System.out.println("parent");
		System.out.println("name : " + name);
	} //그런데 print 한 개만 구현헀으므로
	  //parent는 추상클래스이며, 객체를 가질 수 없다.
}
