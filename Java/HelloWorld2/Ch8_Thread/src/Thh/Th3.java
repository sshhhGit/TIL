package Thh;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

class RandomTh extends Thread{
	Container contentPane;
	boolean flag = false;
	
	public RandomTh(Container cp) {
		// TODO Auto-generated constructor stub
	}
	public void Random(Container contentPane) {
		this.contentPane = contentPane;
	}
	void finish() {
		flag = true;
	}
	@Override
	public void run() {
		while(true){
			JLabel la = new JLabel("꽃");
			la.setSize(80, 30);
			la.setFont(new Font("고딕체",Font.BOLD,14));
			la.setForeground(Color.yellow);
			
			int x = (int)(Math.random()* contentPane.getWidth());
			int y = (int)(Math.random()* contentPane.getHeight());
			la.setLocation(x, y);
			
			contentPane.add(la);
			contentPane.repaint();
			
			try {
				sleep((int)(Math.random()*1000));
				if(flag ==true) {
					contentPane.removeAll();
					
					JLabel finishJLabel = new JLabel("끝났습니다.");
					finishJLabel.setFont(new Font("고딕체",Font.PLAIN,26));
					finishJLabel.setForeground(Color.PINK);
					finishJLabel.setSize(1000, 100);
					finishJLabel.setLocation(contentPane.getWidth()/2-400,
											 contentPane.getHeight()/2-100);
					
					contentPane.add(finishJLabel);
					contentPane.repaint();
					return;
					
				}
			}catch (InterruptedException e) {
				return;
			}
		}
	}
}
public class Th3 extends JFrame {
	RandomTh rt;
	
	Th3() {
		
		Container cp = getContentPane();
		cp.setBackground(Color.black);
		cp.setLayout(null);
		
		cp.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				rt.finish();
			}
		});
		
		rt = new RandomTh(cp);
		
		setSize(1300, 700);
		setVisible(true);
		
		rt.start();
	}
	
	public static void main(String[]args) {
		new Th3();
	}
}
