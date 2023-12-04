package Java.c13_IO_stream.f04_try_with_resources;

import java.io.*;

public class CopyExample {
	/*
	 * Cat 이미지를 C:\\Temp 폴더 아래에 가져오기 (cat1.jpg)
	 * 이미지를
	 * C:\\Temp\images\copy.jpg
	 * 파일로 복사하여 새로운 파일로 생성
	 */
	public static void main(String[] args) {
		String imgDir = "C:\\Temp\\";
		String img = "Cat1.jpg";
		String copyImgDir = "C:\\Temp\\image\\";
		String copyImg = "copy.jpg";
		File file = new File(copyImgDir);
		if (!file.exists()) {
			boolean d = file.mkdirs();
			System.out.println("폴더 생성 완료");
			file = new File(copyImgDir+copyImg);
			if (!file.exists()) {
				try {
					boolean f = file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("파일 생성 완료");
			}
		}
		try (
				InputStream is = new FileInputStream(imgDir+img);
				OutputStream os = new FileOutputStream(copyImgDir+copyImg);
				) {
			int data;
			while ((data = is.read()) != -1) {
				os.write(data);
			}
			os.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
