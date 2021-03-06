package EX;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 	바이트단위 스트림
 * 		1. InputStream
 * 				|
 * 			   fileInputStram : 파일에서 바이트 단위로 읽어온다.
 * 			   ByteArrayInputStream
 * 				
 * 				. int read() : 읽은 바이트수를 반환, -1
 * 				. void close() : 대상리소스를 닫는다.
 * 		2. OutputStream
 * 		 		|
 * 			   fileOutputStream : 파일에 바이트단위로 출력
 */

public class IO2_바이트단위스트림 {
	public static void main(String []args) {
		try {
			FileInputStream fin = new FileInputStream("C:\\MyJava\\workspace\\file\\Bs2.txt"); //01001000 
			InputStreamReader in = new InputStreamReader(fin,"UTF-8");
			
			int c;
			while((c=in.read()) != -1) {
				System.out.println((char)c);
			}
			
		}catch (IOException e) {
			System.out.println(e);
		}
	}
}
