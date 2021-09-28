package ch02_awt;

import java.awt.*;
import java.awt.event.*;

public class Test04_ActionEvent extends Frame implements ActionListener{

	TextField tf1, tf2;
	TextArea ta;
	
	public Test04_ActionEvent() {
		// TODO Auto-generated constructor stub
		setTitle("대화하기");
		
		tf1 = new TextField();
		tf2 = new TextField();
		ta  = new TextArea();
		
		ta.setEditable(false);
		
		tf1.setBackground(Color.yellow);
		tf2.setBackground(Color.YELLOW);
		
		add(tf1,"North");
		add(ta,"Center");
		add(tf2,"South");
		
		setSize(450, 450);
		setVisible(true);
		
		addWindowListener(new MyWin());
		tf1.addActionListener(this);
		tf2.addActionListener(this);
	}
	
	class MyWin extends WindowAdapter{
		public void windowClosing(WindowEvent we) {
			System.exit(0);
		}
	}
	public void actionPerformed(ActionEvent e){
		if (e.getSource()==tf1) {
			String temp = tf1.getText().trim();
			if(!temp.equals("")){
				String msg = "홍길동>"+temp;
				ta.append(msg+"\n");
				tf1.setText("");
			}
		}else if(e.getSource()==tf2){
			String temp = tf2.getText().trim();
			if(!temp.equals("")){
				String msg = "김길동>"+temp;
				ta.append(msg+"\n");
				tf2.setText("");
			}
		}
	}
	public static void main(String[] args) {
		new Test04_ActionEvent();
	}
}
