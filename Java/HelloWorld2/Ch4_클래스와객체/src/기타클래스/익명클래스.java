package 기타클래스;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class 익명클래스 extends JFrame{
	final int FLYING_UNIT = 10;
	JLabel la = new JLabel("★");
	
	익명클래스() {
		setTitle("마우스로 조정하기");
		
		Container c = getContentPane();
		c.setBackground(Color.yellow);
		c.setLayout(null);
		
		//c.addKeyListener(new KeyListener();
		
		la.setLocation(50, 50);
		la.setSize(100, 20);
		c.add(la);
		
		setSize(300,300);
		setVisible(true);
		c.setFocusable(true);
		c.requestFocus();
	}
	/*
	class MyKeyListener implements KeyListener {
		
		@Override
		public void KeyPressed(KeyEvent e) {
			int Keycode = e.getKeyCode();
			
			switch(KeyCode) {
			case KeyEvent.VK_UP;
				la.setLocation(la.getX(), la.getY()-FLYING_UNIT);
				break;
			case KeyEvent.VK_DOWN;
				la.setLocation(la.getX(), la.getY()-FLYING_UNIT);
				break;
			case KeyEvent.VK_LEFT;
				la.setLocation(la.getX(), la.getY()-FLYING_UNIT);
				break;
			case KeyEvent.VK_RIGHT;
				la.setLocation(la.getX()+FLYING_UNIT la.getY()-);
				break;
			}
		}
		@Override
		public void KeyReleased(KeyEvent e) {
			
		}
		@Override
		public void KeyTyped(KeyEvent e) {
	
		}
			*/	
		public static void main(String []args) {
			new 익명클래스();
		}
	}

