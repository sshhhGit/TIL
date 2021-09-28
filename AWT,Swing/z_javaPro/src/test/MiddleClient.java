package test;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.xml.ws.handler.MessageContext.Scope;

import java.io.*;
import java.net.*;
import java.util.*; //Vector 스레드 기능 이용

//클라이언트, swing JFrame 사용
public class MiddleClient extends JFrame implements ActionListener,Runnable{
	//전역변수
	JButton b1, b2;
	JTextField tf;  //한줄 입력, 대화내용 입력
	JTextArea ta; //대회나용 출력
	String name; //대화명(닉네임)
	
	private DataInputStream in;
	private DataOutputStream out;
	private Thread thread;
	
	JScrollBar scrollBar;
	JScrollPane scrollPane; //JTextArea에 스크롤바 넣기
	
	//생성자, 객체 초기화
	public MiddleClient(String ip, int port) {
		// TODO Auto-generated constructor stub
		try {
			Socket sock = new Socket(ip, port); //서버접속
			in = new DataInputStream(sock.getInputStream()); //객체생성
			out = new DataOutputStream(sock.getOutputStream()); //객체출력
			
		} catch (IOException ex1) {
			// TODO: handle exception
			System.out.println("서버 접속실패, 서버 점검중.");
			System.exit(0);
		}//catch-end
		
		b1 = new JButton("종료", new ImageIcon("c:\\imgs\\a1.gif"));
		b1.addActionListener(this);//이벤트 등록
		
		b2 = new JButton("색상지정", new ImageIcon("c:\\imgs\\a3.gif"));
		b2.addActionListener(this);//이벤트 등록
		
		tf = new JTextField();
		tf.addActionListener(this); //이벤트 등록
		
		ta = new JTextArea();
		ta.setLineWrap(true); //자동 개행
		ta.setEditable(false); //편집 불가
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2, 1)); //2행 1열
		p.add(b1);
		p.add(b2);
		
		scrollPane = new JScrollPane(ta);
		scrollBar = scrollPane.getVerticalScrollBar();
		scrollBar.setValue(scrollBar.getMaximum()); //최대값 설정
		
		//JFrame에 컴포넌트 붙이기
		getContentPane().add("East", p);
		getContentPane().add("Center",scrollPane); //ta
		getContentPane().add("South", tf);
		
		setSize(450, 450);
		setVisible(true);
		tf.requestFocus(); //포커스 설정
		
		name = JOptionPane.showInputDialog(this, "대화명을 입력하세요");
		//							       this:부모객체에 소속 시킨다
		
		thread = new Thread(this); //객체생성
		thread.start(); //run()메서드 호출
	}//con-end

	//서버가 보내준 자료를 클라이언트 화면에 반영 시키는 작업
	@Override
	public void run() { 
		try {
			//정상처리
			while (true) {
				String msg = in.readUTF(); //서버가 보내준 메시지를 받음
				ta.append(msg + "\n");
				scrollBar.setValue(scrollBar.getMaximum());
			}//while-end
		} catch (IOException iox1) {
			ta.append("서버로부터 데이터를 읽어오던 중 에러 발생\n");
			ta.append("10초후에 종료됩니다");
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException ex3) {}
			System.exit(0);
		}//catch-end
	}//run()-end

	//서버로 보내는 작업을 한다
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == tf) { //서버로 대회 내용 보내기
			try {//서버로 보내기
				String msg = tf.getText().trim();
				if(msg.length()<1){
					JOptionPane.showMessageDialog(this, "대화내용을 입력하세요");
					tf.requestFocus(); //포커스 설정
					return; // 피드백, 아래내용 실행 못하게
				}//if-end
				
				//정상처리
				out.writeUTF("[" + name + "] " + msg); //서버로 보내기
				tf.setText(""); //입력한 대화내용을 지운다
				scrollBar.setValue(scrollBar.getMaximum());
				
			} catch (Exception ex) {
				ta.append("대화 내용을 서버로 보내던 중 예외 발생\n");
				ta.append("10초 후에 종료합니다");
				try {
					Thread.sleep(10000);
				} catch (Exception ex3) {}
				System.exit(0);//프로그램 종료
			}//catch-end
		}//if()-end
		if (e.getSource() == b1) { //종료
			int answer = JOptionPane.showConfirmDialog(this, "종료할까요?","창제목 : 종료", JOptionPane.YES_NO_OPTION);
			switch(answer){
			case JOptionPane.YES_OPTION:
				System.exit(0);
				break;
				
			case JOptionPane.NO_OPTION:
				break;
			}//switch-end
		}//if-end
		if (e.getSource() == b2) { //글씨 색 변경
			
			ta.setForeground(Color.blue); //전경색
			ta.setBackground(Color.white); //배경색
			
		}//if-end
	}//actionPerformed()-end
	public static void main(String[] args) {
		new MiddleClient(args[0],Integer.parseInt(args[1]));
	}
}//class-end
