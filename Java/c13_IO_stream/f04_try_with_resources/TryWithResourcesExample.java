package Java.c13_IO_stream.f04_try_with_resources;

import java.io.*;

public class TryWithResourcesExample {

	public static void main(String[] args) {
		
		String path = "C:\\Temp\\file2.txt";
		try (
				InputStream is = new FileInputStream(path);
				FileOutputStream os = new FileOutputStream(path);
				) { // AutoClosable 인터페이스를 구현하고 있는 녀석들만 자원 자동 해제 가능
			
			int data;
			while((data = is.read()) != -1) {
				System.out.println(data);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

