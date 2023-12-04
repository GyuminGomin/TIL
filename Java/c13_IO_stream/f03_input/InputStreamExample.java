package Java.c13_IO_stream.f03_input;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamExample {

	public static void main(String[] args) {
		
		InputStream is = null;
		
		try {
			File file = new File("C:\\temp\\file2.txt");
			is = new FileInputStream(file); // 파일이 존재하지 않으면 무조건 에러 있을 때만 생성
			int readByte = 0;
			
			while(true) {
				// byte 단위로 읽어와서 읽은 byte를 int type으로 반환
				readByte = is.read();
				System.out.println(readByte);
				// EOF (End Of File == -1)
				if (readByte == -1) break;
			}
			is.close(); // 만약 close하지 않는다면 garbage collector가 처리하기 전까지 계속 붙들려 있음.
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
