package ch14;

public class CloneTestMain {

		public static void main(String[] args) {
			CloneTest c1 = new CloneTest(); //cloneTest의 객체를 생성 
			CloneTest c2 = null;
			
			try {								//생성한 c1객체를 clone()
				c2 = (CloneTest) c1.clone(); 	//메서드로 객체를 복사한다.
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
//16~20번 줄은 c1, c2 객체 멤버에 서로 다른 값을 할당
		c1.x = 10;
		c1.y = 20;
		
		c2.x = 30;
		c2.y = 40;
//22~26번 줄은 c1, c2의 멤버변수 값들과 참조값을 출력, 값들이 다르고, 참조 값이 다름.		
		System.out.println("c1.x = " + c1.x + ", c1.y = " + c1.y);
		System.out.println(c1);
		
		System.out.println("c2.x = " + c2.x + ", c2.y = " + c2.y);
		System.out.println(c2);
		}
		}