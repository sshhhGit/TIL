package 클래스와객체;

class Parking {
	String name;
	int inTime;
	int outTime;
	final int AMTPERTIME = 3000;  //값을 중간에 변하지 못하게 할때
	
	Parking(String n, int in, int out) {
		name = n;
		inTime = in;
		outTime = out;
	}
	
	void print() {
		int fee = (outTime-inTime)*AMTPERTIME; 
		System.out.println("차이름 : " + name);
		System.out.println("입고시간:" + inTime);
		System.out.println("출고시간:" + outTime);
		System.out.println("주차요금:" + fee);
	}

}

public class C5_ParkingEx {
	public static void main(String [] args) {
		
		Parking p1 = new Parking("소나타" , 10, 14); 
		Parking p2 = new Parking("너도타" , 9, 20); 
		Parking p3 = new Parking("나도타" , 12, 13); 
		
		
		p1.print();
		System.out.println("------------");
		p2.print();
		System.out.println("------------");
		p3.print();

	}
}
