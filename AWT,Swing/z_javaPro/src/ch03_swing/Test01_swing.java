package ch03_swing;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Test01_swing extends JFrame{
	//전역변수
	JButton b1, b2, b3;
	
	//생성자
	public Test01_swing() {
		//FlowLayout으로 설정
		this.getContentPane().setLayout(new FlowLayout());
	
		ImageIcon icon1 = new ImageIcon("c:\\imgs\\a1.gif");
		b1 = new JButton("1번", icon1);
		b1.setToolTipText("첫번째 버튼 입니다.");
		this.getContentPane().add(b1); //b1이 중간계층을 지나서 JFrame에 붙임
		
		ImageIcon icon2 = new ImageIcon("c:\\imgs\\a2.gif");
		b2 = new JButton("2번", icon2);
		b2.setToolTipText("두번째 버튼 입니다.");
		this.getContentPane().add(b2); //b2이 중간계층을 지나서 JFrame에 붙임
		
		ImageIcon icon3 = new ImageIcon("c:\\imgs\\a3.gif");
		b3 = new JButton("3번", icon3);
		b3.setToolTipText("세번째 버튼 입니다.");
		this.getContentPane().add(b3); //b3이 중간계층을 지나서 JFrame에 붙임
		
		setSize(450, 450);
		setVisible(true);
		
		//프로그램 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//메인
	public static void main(String[] args) {
		new Test01_swing(); //객체생성, 생성자 호출
	}
}
