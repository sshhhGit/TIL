package EX;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO3_바이트스단위스트림2 {
	public static void main(String [] args) {
		
		try {
			FileInputStream fin = new FileInputStream("C:\\Windows\\system.ini");
			//InputStreamReader in = new InputStreamReader(fin, "utf-8");
			
			int c;
			while((c=fin.read()) != -1) {
				System.out.println((char)c);
			}
			
		}catch(IOException e) {
			System.out.println("입력중에 오류가 발생되었습니다.");
		}
	}
}
