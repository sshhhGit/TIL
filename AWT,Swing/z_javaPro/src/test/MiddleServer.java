package test;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.util.*;

public class MiddleServer extends Frame{

	public TextArea ta; 
	
	public MiddleServer() {
		// TODO Auto-generated constructor stub
		setTitle("채팅방 관리자");
		ta = new TextArea(200, 100); //200칸, 100줄
		
		this.setFont(new Font("Dialog", Font.BOLD,20));
		ta.setEditable(false); //편집불가
		this.add("Center", ta); //Frame에 ta붙이기
	}
	
	public static void main(String[] args) {
		if(args.length != 1){
			System.out.println("입력 용법 => java MiddleServer 7788");
			System.exit(0);
		}
		
		MiddleServer f = new MiddleServer(); //객체생성
		f.setSize(450, 450);
		f.setVisible(true);
		
		int i = 1; //접속인원 관리 변수
		
		try {
			ServerSocket ss = new ServerSocket(Integer.parseInt(args[0]));
			
			System.out.println("서버 구동중");
			
			while (true) {
				Socket sock = ss.accept();//클라이언트 접속을 받는다
										  //클라이언튼 소켓과 서버 소켓 연결
				f.ta.append(i+"번째 손님이 방문하였습니다.\r\n"+sock+"\n");
				
				new Handler(sock,i,f.ta).start(); //객체생성
				i++;
					
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}//class-end
class Handler extends Thread{
	
	private int number;
	private static Vector vec = new Vector();
	private TextArea ta;
	
	private Socket sock;
	
	private DataInputStream in;
	private DataOutputStream out;
	
	//생성자
	public Handler(Socket s, int temp, TextArea ta) throws Exception{
		this.sock = s;
		this.number = temp;
		this.ta = ta;
		
		in = new DataInputStream(sock.getInputStream());
		out = new DataOutputStream(sock.getOutputStream());
	}
	
	public void run() {
		try {
			vec.add(this);
			while(true){
				String msg = in.readUTF(); //클라이언트가 보낸 대회내용을 받는다
				toMsg(msg); //모든 클라이언트에게 보낸다
			}//while-end
			
		} catch (IOException ex2) {
			ta.append(number + "번째 손님이 퇴장하였습니다.\n"); //서버
			toMsg(number + "번째 손님이 퇴장하였습니다.\n"); //클라이언트
			vec.remove(this); //지금 채팅방에서 나간 친구를 vec에서 제거
			
			try {
				sock.close();
			} catch (IOException ex3) {
				System.out.println("소켓을 닫는 중 예외 발생 : " + ex3);
			}
		}//catch-end
	}//run-end
	
	//사용자 정의 메서드, 클라이언트로 보내는 목적
	private void toMsg(String msg){
		synchronized (vec) {
			Enumeration e = vec.elements(); //모든 클라이언트를 꺼내서 e에 할당
			while (e.hasMoreElements()) {
				Handler hh = (Handler)e.nextElement();
				
				try {
					hh.out.writeUTF(msg); //모든 클라이언트에게 msg를 보낸다
					
				} catch (IOException ex5) {
					try {
						sock.close();
					} catch (IOException ex7) {
						ex7.printStackTrace();
					}//catch-end
					System.out.println("msg 보내던 중 예외 발생 : " + ex5);
				}//catch-end
			}//while-end
		}//synchronized-end
	}//toMsg()-end
}//class-end
/**
  실행 :
  C:\_jsp\spring_work\z_javaPro\bin>
  cmd java test.MiddleServer 7788
*/