package Java.c13_IO_stream.f05_reader_writer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class ReaderWriterExample {

	public static void main(String[] args) {
		String path = "C:\\Temp\\data.hwp";
		// path = "\\\\10.100.205.231\\public\\강사 연락처 및 공유폴더.txt"; // 수정 권한이 없어 수정 불가 but 권한을 받으면
		Reader reader = null;
		Writer writer = null;
		
		try {
//			writer = new FileWriter(path); // 객체 생성시 2번째 매개변수가 없으면 기존에 있는 데이터를 삭제하고 준비하므로, 읽을 게 없음 
			reader = new FileReader(path);
			
			char[] chars = new char[100];
			
			int readChar;
			String result = "";
			
			while ((readChar = reader.read(chars)) != -1) {
				result += new String(chars, 0, readChar);
			}
			System.out.println(result);
			writer = new FileWriter(path); // 따라서 reader를 하고 난 뒤 선언
			Scanner sc = new Scanner(System.in);
			System.out.println("추가할 문자를 입력해 주세요.");
			String add = sc.nextLine();
			result += add; // 원래 받은 데이터에 추가해주어야 함.
			writer.write(result);
			writer.flush();
			sc.close(); // Scanner 의 자원 할당 해제
			
		} catch (FileNotFoundException e) {
			System.out.println("지정된 파일을 찾을 수 없음 : "+ e.getMessage());
		} catch (IOException e) {
			System.out.println("파일 요청 처리를 할 수 없음 : " + e.getMessage());
		} finally {
			try {
				if (reader != null) reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (writer != null) writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

