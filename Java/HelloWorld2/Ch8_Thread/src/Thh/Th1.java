package Thh;
//Thread 클래스
//Runnable 인터페이스

import java.security.Signature;
/*
	new() 생성
	|
	start() 	runnable상태-----JVM이 실행
	|
	waite()		blocked상태------notify ----runnable
	또는
	sleep() 	blocked상태------시간이 다지나면 --runnable상태
*/
class MyThread extends Thread {

	@Override
	public void run() {
		
		for(int i = 0; i < 5; i++) {
			System.out.println("딩~");
			
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}



public class Th1 {
	public static void main(String []args){
		
		Thread th1 = new Thread() {
			@Override
			public void run() {
				
			}
		};
		
		th1.start();
		
		//MyRunnable mr = new MyRunnable();
		//Thread th1 = new Thread();
		//th1.start();
		
		
		for(int i = 0; i < 5; i++) {
			System.out.println("떙~");
			
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		Thread th2 = new Thread();
		th2.start();
		th1.start();
		
		
	}	
	
}
