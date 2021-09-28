package ch01_network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SimpleClient {
	public static void main(String[] args) {
		
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		Socket sock = null;
		
		String msg = "클라이언트 192.168.0.78입니다."+args[1];
		
		try {
			sock = new Socket(args[0],7788);
			
			dis = new DataInputStream(sock.getInputStream());
			System.out.println(dis.readUTF());
			
			dos = new DataOutputStream(sock.getOutputStream());
			dos.writeUTF(msg);
			
			sock.close();
			dis.close();
			dos.close();
			
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
