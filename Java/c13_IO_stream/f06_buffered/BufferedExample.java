package Java.c13_IO_stream.f06_buffered;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedExample {
	
	public static void main(String[] args) throws IOException {
		
		String originalPath = "C:\\Temp\\cat1.jpg";
		File originalFile = new File(originalPath);
		FileInputStream fis = new FileInputStream(originalFile);
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		String copyPath = "C:\\Temp\\dir\\copy.jpg";
		File copyFile = new File(copyPath);
		FileOutputStream fos = new FileOutputStream(copyFile);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		long startTime, endTime;
		
		int data;
		startTime = System.nanoTime();
		while((data = fis.read()) != -1) {
			fos.write(data);
		}
		fos.flush();
		endTime = System.nanoTime();
		System.out.printf("file : %d ns %n", (endTime-startTime));
		
		startTime = System.nanoTime();
		while((data = bis.read()) != -1) {
			bos.write(data);
		}
		bos.flush();
		endTime = System.nanoTime();
		System.out.printf("Buffered : %d ns %n", (endTime-startTime));
		
		bos.close();
		bis.close(); // 보조스트림만 자원해제하면 기반스트림도 자동으로 자원해제
		
		System.out.println("copy 완료");
	}