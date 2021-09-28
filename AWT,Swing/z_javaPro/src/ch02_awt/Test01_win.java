package ch02_awt;

import java.awt.*;
import java.awt.event.*;

public class Test01_win extends Frame implements WindowListener{
	int a = 100;
	
	public Test01_win(){
		setTitle("연습1 WindowListener를 사용하여 창 종료");
		this.addWindowListener(this);
		this.setSize(450, 450);
		this.setVisible(true);
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		dispose(); //리소스 반환
		System.out.println(0); //프로그램 종료, 창 종료
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		new Test01_win();
	}
}
