package EX;

import java.io.FileOutputStream;
import java.io.IOException;

public class IO4_바이트단위스트림3 {
	public static void main(String[] args) {
		
		try {
			
			FileOutputStream fout = new FileOutputStream("C:\\MyJava\\workspace\\file\\Bs3.txt");
			
			fout.write(72);
			fout.write(65);
			fout.write(80);
			fout.write(80);
			fout.write(89);
			fout.write(32);
			fout.write(74);
			fout.write(65);
			fout.write(86);
			fout.write(65);
			fout.write(33);
			
			System.out.println("정상적으로 파일이 생성되었습니다.");
			fout.close();
			
			FileOutputStream foss = new FileOutputStream("C:\\MyJava\\workspace\\file\\Bs3.txt", (true));
			byte[] bs = new byte[26];
			byte data = 65;
			for(int i = 0; i <bs.length; i++) {
				bs[i] = data;
				data++;
			}
			
			foss.write(bs);
			foss.write(13);
			foss.write(10);
			
			foss.close();
			System.out.println("정상적으로 파일이 생성되었습니다.");
			
		}catch (IOException e) {
			
		}
	}
}
