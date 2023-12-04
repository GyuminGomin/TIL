package Java.c13_IO_stream.f01_file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample {
	
	public static void main(String[] args) {
		String dir = "C:/temp/dir/aaa"; // linux 경로
		dir = "C:\\temp\\dir\\aaa"; // window 경로
		
		String separator = File.separator; // System이 동작되고 있는 운영체제에 따라 / 또는 \를 제공해줌
		System.out.println(separator); // window는 \이므로 \이 출력
		
		dir = "C:"+File.separator+"dir"+File.separator+"aaa";
		System.out.println(dir);
		
		char separatorChar = File.separatorChar;
		System.out.println(separatorChar); // Char 타입으로 separator제공
		
		dir = "";
		System.out.println("dir : " + dir);
		
		File file = new File(dir);
		// 절대 경로
		System.out.println(file.getAbsolutePath()); // 매개변수 1개일 때 공백은 현재 프로그램 위치
		// 저장된 경로
		System.out.println(file.getPath());
		
		file = new File(dir,"Temp"); // 상위디렉토리, 하위에있는 폴더나 파일
		System.out.println(file.getAbsolutePath()); // 매개변수 2개일 때는 공백은 상위디렉토리
		System.out.println(file.getPath());
		
		// file.exist() - 해당 위치에 폴더나 파일이 존재하면 true 존재하지 않으면 false
		if(!file.exists()) {
			// 디렉토리 또는 파일이 존재하지 않음
			
			// 지정된 경로에 있는 디렉토리 중 마지막에 정의된 디렉토리 생성
			// 중간에 지정된 폴더가 없으면 생성 불가
			boolean isMake = file.mkdir();
			System.out.println("디렉토리 생성 여부 : "+ isMake);
		}
		
		file = new File(file,"dir"+File.separator+"aaa");
		System.out.println("absolute : " +file.getAbsolutePath());
		
		if(!file.exists()) {
			System.out.println("디렉토리가 존재하지 않음");
			
			boolean isMake = file.mkdir();
			System.out.println("디렉토리 생성 여부 : " + isMake);
			// 경로상에 정의된 모든 디렉토리를 생성
			isMake = file.mkdirs();
			System.out.println("디렉토리 생성 여부 : " + isMake);
		}
		
		String fileName = "test.txt";
		
		file = new File(file, fileName);
		System.out.println("absolute : " +file.getAbsolutePath());
		
		if (file.exists() == false) {
			System.out.println("파일이 존재하지 않음");
			// 생성 권한이 없을 수도 있고, 디렉토리에 파일이 꽉 찼을 수도 있다.
			try {
				file.createNewFile(); // 새 파일 생성
				System.out.println("새 파일 생성 완료");
			} catch (IOException e) {
				System.out.println("파일 생성 실패 : "+ e.getMessage());
			}
		}
		
		File file1 = new File("C:\\Temp\\file1.txt");
		
		if (!file1.exists()) {
			// alt + s + w : 블럭형태로 try catch
			try {
				boolean isMake = file1.createNewFile();
				System.out.println("파일 생성 여부 : " + isMake);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String path = file1.getAbsolutePath();
		System.out.println("absolute : "+ path);
		
		File temp = new File("C:\\temp");
		// temp에 저장되어 있는 파일들 목록을 가져와서 배열로 저장
		File[] temps = temp.listFiles();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
		
		for (File f : temps) {
			// 폴더나 파일의 마지막 수정 시간을 millis seconds 로 반환
			long modified = f.lastModified();
			Date date = new Date(modified);
			String lastModified = sdf.format(date);
			System.out.println(lastModified);
			if(f.isDirectory()) { // 디렉토리 인가
				System.out.println("\t<dir>\t\t\t"+f.getName());
			} else {
				System.out.println("\t<FILE>\t\t\t"+f.getName());
			}
		} // end for
		
		// 삭제
		File file2 = new File("C:\\Temp\\dir\\aaa\\test.txt");
		boolean isDeleted = false;
		isDeleted = file2.delete();
		System.out.println("파일 삭제 여부 : "+ isDeleted);
		
		file2 = new File("C:\\Temp\\dir\\aaa");
		isDeleted = file2.delete();
		System.out.println("디렉토리 삭제 여부 : "+ isDeleted);
	}
}
