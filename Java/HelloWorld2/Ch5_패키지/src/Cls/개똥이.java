package Cls;
class A extends Object1{
	
}
class B extends A{
	
}
class C extends B{
	
}

public class 개똥이{

	public static void main(String []args) {
	
		A a = new A();
		System.out.println(a.toString());
		
		B b = new B();
		System.out.println(b.toString());
		
		Object1 obj1 = new A();
		Object1 obj2 = new B();
		Object1 obj3 = new C();
		
		Object1 [] arr = new Object1[3];
		arr[0] = new A();
		arr[1] = new B();
		arr[2] = new C();
		
		A aa = (A)arr[0];
		
		
		
	}
	
	
}
