package EX;

import java.io.FileReader;
import java.io.IOException;

public class IO6_문자단위스트림 {
	public static void main(String []args) {
		
		FileReader in = null;
		try {
			
			in = new FileReader("C:\\Windows\\system.ini"); 
			int c;
			while((c=in.read()) != -1) {
				System.out.print((char)c);
			}
			in.close();
			
		} catch(IOException e) {
			System.out.println("데이터 읽기 실패");
		}
	} 
}
