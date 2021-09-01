package bak;

import 클래스와객체.Access;

class Access4 {
	Access ac = new Access();
	{
		//ac.nProtected = 30; 다른패키지에 상속관계가 아니다
		ac.nPublic = 40;	
	}
}

public class Access3 extends Access {
	int b;
	void b() {
		b = 5;
		//nPrivate = 50; private는 자기 클래스에서만 사용
		nProtected = 10;
		nPublic = 20;
		
	}
	
}
