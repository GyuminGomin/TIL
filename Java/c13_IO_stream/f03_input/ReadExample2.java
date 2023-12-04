package Java.c13_IO_stream.f03_input;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class ReadExample2 {

	public static void main(String[] args) throws IOException{
		
		InputStream is = new FileInputStream("C:\\Temp\\file2.txt");
		byte[] bytes = new byte[100];
		int readBytes = is.read(bytes);
		System.out.println(Arrays.toString(bytes));
		System.out.println(readBytes);
		String result = new String(bytes);
		System.out.println(result);
		is.close();
		
		// 한 번 연결이 끊긴 스트림은 재사용 불가
		is = new FileInputStream("C:\\Temp\\file2.txt");
		int available = is.available();
		System.out.println("읽어 들일 수 있는 파일의 크기 : " + available);
		bytes = new byte[available];
		
		readBytes = is.read(bytes, 0, bytes.length);
		System.out.println(Arrays.toString(bytes));
		System.out.println(readBytes);
		available = is.available(); // 읽어 올 데이터가 남아있는 데이터를 읽어오는 것
		System.out.println("읽어 들일 수 있는 파일의 크기 : " + available);
		is.close();
	}
}
