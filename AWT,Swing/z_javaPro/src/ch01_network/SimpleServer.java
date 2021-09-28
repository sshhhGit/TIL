package ch01_network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
	public static void main(String[] args) {
		
		ServerSocket ss = null;
		Socket sock = null;
		
		String msg = "안녕하세요. 행복하세요 서버 192.168.0.78 입니다";
		DataOutputStream dos;
		DataInputStream dis;
		
		try {
			ss = new ServerSocket(7788);
			System.out.println("서버 구동중");
			
		} catch (IOException e) {
			System.out.println("예외 : " + e);
		}
		
		while (true) {
			try {
				sock = ss.accept(); //클라이언트 요청을 받는다, 소켓연결
				
				//대화하기
				dos = new DataOutputStream(sock.getOutputStream());
				dos.writeUTF(msg);
				
				dis = new DataInputStream(sock.getInputStream());
				System.out.println(dis.readUTF());
				
				dos.close();
				dis.close();
				sock.close();
				
			} catch (IOException e2) {
				// TODO: handle exception
				System.out.println(e2);
			}	
		}
	}
}
