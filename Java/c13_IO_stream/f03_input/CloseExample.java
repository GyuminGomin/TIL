package Java.c13_IO_stream.f03_input;

import java.io.*;
import java.util.Scanner;

public class CloseExample {

	public static void main(String[] args) {
		// 지정된 파일에 console을 통해 입력받은 문자열을 출력
		InputStream is = null;
		OutputStream os = null;
		String path = "C:\\Temp\\file23.txt";
		
		try {
			is = new FileInputStream(path);
			byte[] bytes = new byte[is.available()];
			System.out.println("bytes length : " + bytes.length);
			int readBytes = is.read(bytes);
			
			String result = new String(bytes,0,readBytes);
			
			Scanner sc = new Scanner(System.in); // console의 입력 스트림을 통해 전달받는다.
			System.out.println("추가로 저장할 문자열을 입력해주세요 > ");
			String a = sc.next();
			System.out.println(result);
			System.out.println(a);
			a = (result + a);
			
			bytes = a.getBytes();
			os = new FileOutputStream(path);
			os.write(bytes);
			os.flush();
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(is != null)is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(os != null)os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}