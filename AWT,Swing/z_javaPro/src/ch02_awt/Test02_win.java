package ch02_awt;

import java.awt.*; //Frame
import java.awt.event.*; //이벤트 처리

//inner class사용
//WindowAdapter 클래스 사용
public class Test02_win extends Frame{
	
	public Test02_win() {
		setTitle("inner class 사용하여 창 종료");
		setSize(450, 450);
		setVisible(true);
		
		this.addWindowListener(new MyWin());
		
	}
	class MyWin extends WindowAdapter{
		public void windowClosing(WindowEvent we) {
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new Test02_win();
	}
}
