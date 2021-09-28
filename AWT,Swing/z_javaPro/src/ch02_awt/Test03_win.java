package ch02_awt;

import java.awt.*;
import java.awt.event.*;

public class Test03_win extends Frame{

	
	public Test03_win() {
		// TODO Auto-generated constructor stub
		setTitle("무명 inner class로 창 종료");
		setSize(450, 450);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test03_win();
	}

}
