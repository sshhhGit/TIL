package EX;

import java.io.IOException;

/*
 *  1. 스트럼
 *  	- 입출력장치가 너무 다양해서 표준화해놓은 가상통로
 *  	- 모든 입출력 기능에 대해 Stream표준화된 클래스를 제공
 *  	- 기본 단위 1바이트( 문자를 2바이트가 필요, 문자출력에 제공되는 클래스를 제공)
 *  2. 스크림종류
 *     1) 입력이냐 출력이냐
 *     2) 바이트단위냐? 문자(2바이트)단위냐? ~~Stream, ~~~Read, ~~Write
 *     3) 독립적인 클래스냐? 보조적인 클래스냐? File 독립적, 그 외 보조적
 *     
 *     스트림					입/출		바이트/문자		기반/보조
 *     -------------------------------------------------------------
 *     FileReader			  입				문자				기반
 *     FileOutputStream		  출			    바이트			기반
 *     BufferedReader		  입				문자				보조
 *     
 *     3. 입출력 예외
 *     	  . FileNotFoundException
 *     	  . IOException
 *     	  . ClassNotFoundException
 *     
 *     4. 표준입출력
 *     	  . static PrintStream out;
 *     	  . static InputStream in;
 *     	  . static OutputStream
 */
public class IO1_Standard {
	public static void main(String []args) {
		
		System.out.println("알파벳 여러개를 쓰고");
		
		int i;
		try {
			while((i=System.in.read()) != -1) {
				System.out.print(i+":");
				System.out.println((char)i+":");
				System.out.println();
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
