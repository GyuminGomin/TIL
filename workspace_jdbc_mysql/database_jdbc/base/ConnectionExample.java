package workspace_jdbc_mysql.database_jdbc.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionExample {

	public static void main(String[] args) {
		
		try {
			// 8버전은 mysql.cj.jdbc에 존재, 5버전은 mysql.jdbc에 존재
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class 존재");
			
			// java.sql.Connection
			// 1번 방법 (쿼리스트링으로 계정 정보 전달)
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=1234");
			System.out.println(conn);
			conn.close();
			
			// 2번 방법 (매개변수로 계정 정보 전달)
			conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306",
				"root",
				"1234"
			);
			System.out.println(conn);
			conn.close();
			
			// 3번 방법 (Properties 객체 사용)
			Properties prop = new Properties();
			prop.setProperty("user", "root");
			prop.setProperty("password", "1234");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", prop);
			System.out.println(conn);
			conn.close();
			
			// 4번 방법 (properties file 활용)
			File file = new File("workspace_jdbc_mysql/database_jdbc/prop/mysql.properties");
            // 현재 프로젝트 (vscode에서 가장 진하게 표시된 폴더(최상단 폴더)) 에서 경로를 지정해줘야 함
			FileReader reader = new FileReader(file); // 2byte씩 끊어줌
			prop = new Properties();
			prop.load(reader);
			
			System.out.println(prop);

            String url = prop.getProperty("url");
			System.out.println(url);
			
			conn = DriverManager.getConnection(url, prop);
			System.out.println(conn);
			conn.close();
			
		} catch (ClassNotFoundException e) { // Driver가 없을 때
			e.printStackTrace();
		} catch (SQLException e) { // 우리가 지정한 계정정보나 mysql이 없을 때
			e.printStackTrace();
		} catch (FileNotFoundException e) { // properties 파일이 없을 때
			e.printStackTrace();
		} catch (IOException e) { // properties 파일이 이미 사용되고 있을 수도 있음
			e.printStackTrace();
		}
	}
}

