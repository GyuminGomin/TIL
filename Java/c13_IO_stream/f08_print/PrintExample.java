package Java.c13_IO_stream.f08_print;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintExample {

	public static void main(String[] args) {
		File file = new File("data.txt");
		
		try {
			FileOutputStream fos = new FileOutputStream(file, true);
			PrintStream ps = new PrintStream(fos, true); // auto flush(true)
			ps.println(); // 줄바꿈
			ps.println("[프린트 보조 스트림]");
			ps.print(1);
			ps.print(" 맞장구 ");
			ps.printf("A의 값은 %d", 100);
			ps.println();
			ps.close();
			
			PrintWriter pw = new PrintWriter(fos, true);
			pw = new PrintWriter(new FileWriter(file, true), true); // auto flush(true)
			pw.println("PrintWriter 사용방법은 동일");
			pw.print("A");
			pw.printf("%s 입니다. %n", "김규민");
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}