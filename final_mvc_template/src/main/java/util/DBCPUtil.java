package util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public interface DBCPUtil {
	
	/*
	 * @return connection pool에서 connection 반환
	 */
	public static Connection getConnection() {
		Connection conn = null;
		
		// JNDI(Java Naming and Directory Interface)
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:comp/env/java/MySQL_DBCP"); // 이름으로 찾아오기 때문에 무슨 타입인지 모르므로, 타입변환 필수
			conn = ds.getConnection();
			System.out.println(conn);
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/*
	 * 외부 자원과 연결된 객체의 자원해제
	 */
	public static void close(AutoCloseable... closer) {
		for (AutoCloseable c : closer) {
			if (c != null) {
				try {
					c.close();
				} catch (Exception e) {}
			}
		}
	}
}
