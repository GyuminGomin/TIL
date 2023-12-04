package Java.c13_IO_stream.f03_input;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {

	public static void main(String[] args) {
		
		try {
			InputStream is = new FileInputStream("C:\\temp\\file2.txt");
			int readBytes = 0;
			// 연결된 파일에서 읽어 들일 수 있는 데이터 크기(byte 크기)
			int size = is.available();
			
			byte[] bytes = new byte[100];
			bytes = new byte[6];
			
			String data = "";
			
			while(true) {
				readBytes = is.read(bytes); // 읽은 걸 bytes 배열에 저장
				System.out.println("읽어들인 바이트 크기 : " + readBytes);
				if (readBytes == -1) break;
//				data += new String(bytes); // bytes배열을 String으로 반환
				data += new String(bytes,0,readBytes); // 공백을 제거해주기 위해
			}
			System.out.println(data);
			System.out.println(data.length());
			is.close();
			System.out.println(size);
		} catch (IOException e) { // FileNotFoundException은 IOException의 자식
			e.printStackTrace();
		}
	}
}
