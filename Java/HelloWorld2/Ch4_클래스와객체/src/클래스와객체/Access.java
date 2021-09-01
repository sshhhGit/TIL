package 클래스와객체;
/*
   private : 선언된 해당 클래스 안에서만 접근가능
   default : 같은 패키지 안에서 접근가능
   protected : 같은 패키지 안에서 접근가능 + 다른 패키지이지만 상속
   			   관계일 때 접근가능
   public  : 다른 패키지에서도 접근가능
   
 */



public class Access {
				int Default;
	  private 	int nPrivate;  
	protected 	int nProtected;
	   public 	int nPublic;
	  
	 void print() {
		 nPrivate = 10;
	 }
}
class Access2 {
	Access ac = new Access();
	{
		ac.Default = 10;
		//ac.nPrivate = 20;   //접근불가
		ac.nProtected = 30;
		ac.nPublic = 40;
		
	}
}

