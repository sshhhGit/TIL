package EX;

import java.io.FileWriter;
import java.io.IOException;

public class IO7_문자단위스트림 {
	public static void main(String [] args) {
		
		try {
			FileWriter fout = new FileWriter("C:\\MyJava\\workspace\\file\\Bs4.txt"
					);
			
			fout.write("오늘이 마지막수업");
			fout.write('A');
			
			char[]buff = {'b','c','d','e','f','g'};
			fout.write(buff);
			fout.write(buff,1,2);
			
			fout.close();
			System.out.println("데이터 쓰기가 성공");
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
