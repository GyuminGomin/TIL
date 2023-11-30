package Java.c12_collection_framework.c3_map;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExample {

	public static void main(String[] args) {
		Properties prop = new Properties(); // String String이라 따로 제네릭을 생성할 필요가 없음
		prop.put("key", "value");
		prop.put("score", 10);
		System.out.println(prop);
		prop.clear();
		
		prop.setProperty("key", "key value"); // put방식을 사용하지 않음
		String value = prop.getProperty("key");
		System.out.println("value : " + value);
		value = prop.getProperty("김규민", "키 없음"); // 해당 데이터가 없을 때, null 이 아닌 default 값
		System.out.println("value : " + value);
		
		System.out.println("======================================");
		
		// Warning
		String path = PropertiesExample.class.getResource("db.properties").getPath();
		System.out.println(path);
		
		Properties prop2 = new Properties();
		try {
			prop2.load(new FileReader(path)); // load : key값 value값 따로 읽게 해줌
			System.out.println(prop2.size());
			String userName = prop2.getProperty("username");
			String password = prop2.getProperty("password");
			System.out.println("userName : " + userName);
			System.out.println("password : " + password);
		} catch (FileNotFoundException e) {
			e.printStackTrace(); // file이 존재하지 않을 때,
		} catch (IOException e) {
			e.printStackTrace(); // file의 key와 value가 key=value가 아닌 == 이나 /이나 다른걸로 지정되어 읽어올 수 없을 때
		}
	}
}
