package Java.c13_IO_stream.f03_input;

import java.io.*;

public class ReadWriteExample {

	public static void main(String[] args) {
		
		File file = new File("src\\f03_input\\ReadExample.java");
		System.out.println(file.length());
		
		try {
			InputStream is = new FileInputStream(file);
			
			int data;
			
			OutputStream os = System.out; // System.out으로 콘솔에 출력 가능
			while((data = is.read()) != -1)  {
				os.write(data); // is.read()를 1byte씩 읽어오다가 -1만나면 종료
			}
			os.flush();
			System.out.println("끝!!!");
			os.close();
			is.close();
			System.out.println("끝!!!"); // 운영체제에 있는 콘솔과 연결이 끊김
			System.out.println("끝!!!");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
