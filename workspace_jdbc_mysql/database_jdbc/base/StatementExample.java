package workspace_jdbc_mysql.database_jdbc.base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

public class StatementExample {

	public static void main(String[] args) {
		// Statement - Connection 객체의 연결정보를 이용하여 질의를 실행하고 결과를 반환
		// DBMS 와 연결된 session 정보를 저장하고 있는 객체 - 네트워크 상에서 송수신이 가능한 연결 상태(session)
		Connection conn = null;
		// session 내에서 질의 전송을 도와주는 객체
		Statement stmt = null;
		// 검색 질의의 결과 정보를 행단위로 저장하는 객체
		ResultSet rs = null;
		
		try {
			// Class.forName("com.mysql.cj.jdbc.Driver");
			Properties prop = new Properties();
			prop.load(new FileReader("workspace_jdbc_mysql/database_jdbc/prop/mysql.properties"));
			System.out.println(prop);
			
			conn = DriverManager.getConnection(
				prop.getProperty("url"),
				prop
			);
			System.out.println(conn);
			
			// 연결된 DBMS에서 지정된 데이터베이스에 질의를 수행할 Statement 객체 반환
			stmt = conn.createStatement();
//			String sql = "SELECT * FROM sqldb.userTbl";
			String sql = "SELECT * FROM userTbl"; // 지정할 필요 없이 mysql.properties 파일 수정 (기본 스키마 설정)
			
			// 검색 질의 실행 후 결과를 저장
			rs = stmt.executeQuery(sql);
			
			// rs.next()
			// 읽어올 행 정보가 있으면 해당 위치로 cursor를 이동한 후 true를 반환, 그렇지 않으면 false 반환
			while(rs.next()) {
				String userId = rs.getString(1);
				String name = rs.getString(2);
				int birthYear = rs.getInt("birthYear");
				String addr = rs.getString("addr");
				String mobile1 = rs.getString(5);
				String mobile2 = rs.getString(6);
				int height = rs.getInt("height");
				// java.util.Date
				Date mDate = rs.getDate(8);
				String result = String.format("%s-%s-%d-%s", userId,name,birthYear,addr);
				System.out.println(result);
				System.out.println("--------------------------------");
			}
			rs.close();
			stmt.close();
			// 검색 쿼리 작업 자원해제
			
			// 테이블에 삽입할 값을 입력받음
			Scanner sc = new Scanner(System.in);
			System.out.println("userID를 입력해 주세요.");
			String id = sc.next();
			System.out.println("이름을 입력해 주세요.");
			String name = sc.next();
			System.out.println("생년월일을 입력해 주세요 ex) 1982");
			int birthYear = sc.nextInt();
			System.out.println("주소를 입력해 주세요 (도시이름 2자)");
			String addr = sc.next();
			
			sql = "INSERT INTO userTbl(userID, name, birthYear, addr) VALUES ('"+id+"','"+name+"',"+birthYear+",'"+addr+"')";
			System.out.println(sql);
			
			// 질의를 수행하기 위한 statement 객체 생성
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			System.out.println(result+"개의 행 삽입 완료");
			
			stmt.close();
			conn.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("properties 파일을 찾을 수 없음");
		} catch (IOException e) {
			System.out.println("properties 파일을 찾을 수 없음");
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 정보 오류");
		}
	}
}
