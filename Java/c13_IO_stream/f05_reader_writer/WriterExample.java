package Java.c13_IO_stream.f05_reader_writer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterExample {

	public static void main(String[] args) {
		
		try {
			Writer writer = new FileWriter("C:\\Temp\\data.hwp", true); // 이어쓰기 할건지 아닌지
			String strs = "김규민님";
			char[] chars = strs.toCharArray(); // char 타입의 배열로 변환
			/*
			for (char c : chars) {
				writer.write(c);
			}
			*/
//			writer.write(chars); // chars 배열을 직접 전달해서 출력하게 가능
//			writer.write(chars,3,1);
			writer.write("김유신님"); // 직접 문자열 지정 가능
			
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // end main
}
