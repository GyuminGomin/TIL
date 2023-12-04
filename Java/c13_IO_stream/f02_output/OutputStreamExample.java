package Java.c13_IO_stream.f02_output;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class OutputStreamExample {
	
	public static void main(String[] args) {
		
		String path = "C:\\Temp\\file2.txt";
		
		try {
//			OutputStream os = new FileOutputStream(path); // 객체가 생성되면서 기존파일에 있던 내용을 모두 삭제( 새로쓰기 )
			OutputStream os = new FileOutputStream(path, true); // 2번째 매개변수는 append ( 이어쓰기 ), default = false ( 새로 쓰기 )
			String s = "한글";
			byte[] strs = s.getBytes();
			System.out.println(Arrays.toString(strs)); // UTF에서는 3byte이지만, 내부에선 2바이트로 자동반환 따라서 3byte라고 생각
			/*
			for(int i=0; i < strs.length; i++) {
				// 1bytes씩 출력
				// 출력할 수 있는 권한이 없거나, 파일이 옮겨지거나 하면 오류 발생 가능
				os.write(strs[i]);
			} */
			// 매개변수로 넘겨받은 모든 byte 배열을 출력
			// os.write(strs);
			// [-19, -107, -100, -22, -72, -128]로 저장되어있는데, 3번째 인덱스부터 3개만큼만 출력
			os.write(strs, 3, 3);
			os.flush(); // 마지막 버퍼에 남아있는 데이터를 출력해주기 위해 필요
			os.close();
		} catch (FileNotFoundException e) { // 지정된 경로의 디렉토리가 없을 경우
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
