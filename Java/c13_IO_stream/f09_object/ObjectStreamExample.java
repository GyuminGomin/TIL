package Java.c13_IO_stream.f09_object;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class ObjectStreamExample {

	public static void main(String[] args) {
		
		try {
			FileOutputStream fos = new FileOutputStream("object.dat");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			
			oos.writeObject(Integer.valueOf(85));
			oos.writeObject(3.14); // 자동 boxing
			oos.writeObject(new int[] {1,2,3,4});
			oos.writeObject(new String("김규민"));
			
			oos.writeObject(97);
			oos.writeObject(Double.valueOf("3.141592"));
			oos.writeObject(new int[] {90,70,60,40});
			oos.writeObject("이순신");
			
			oos.flush();
			oos.close();
			
			System.out.println("출력 완료");
			
			FileInputStream fis = new FileInputStream("object.dat");
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
			
			int result = fis.available();
			System.out.println(result);
			
			result = bis.available();
			System.out.println(result);
			
			int avail;
			while((avail = bis.available()) > 0) {
				System.out.println("available : " + avail);
				// 객체 타입으로 저장된 순서대로 역직렬화 해야 타입에 맞게 변환하여 사용
				Integer obj1 = (Integer)ois.readObject();
				Double obj2 = (Double)ois.readObject();
				int[] obj3 = (int[])ois.readObject();
				String obj4 = (String)ois.readObject();
				
				System.out.println("obj1 : " + obj1);
				System.out.println("obj2 : " + obj2);
				System.out.println("obj3 : " + Arrays.toString(obj3));
				System.out.println("obj4 : " + obj4);
			}
			
			ois.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
