package EX;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO5_바이트단위스트림4 {
	public static void main(String[] args) {
		
		try {
			FileOutputStream fout = new FileOutputStream("C:\\MyJava\\workspace\\file\\Bs4.txt");
			
			for(int i = 0; i< 10; i++) {
				int n = 10 - i;
				fout.write(n);
			}
			fout.close();
			System.out.println("정상적으로 파일이 생성되었습니다.");
			
		} catch(IOException e) {
			
		}
		
		try {
			// FileInputStream fin = FileInputStream("C:\\MyJava\\workspace\\file\\Bs4.txt"(false));
			FileReader fr = new FileReader("C:\\MyJava\\workspace\\file\\Bs4.txt");
			
			 int c;
			 while((c=fr.read()) != -1) {
				 System.out.print(c);
			 }
			 fr.close();
			
			 
		} catch(IOException e) {
			
		}
		
	}
}
