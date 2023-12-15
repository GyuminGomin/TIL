package workspace_jdbc_mysql.database_jdbc.base;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementExample {

	public static void main(String[] args) {
		
		Connection conn = null;
		// 동적인 쿼리 객체
		// 쿼리문을 먼저 등록 시켜놓고 질의 실행에 필요한 데이터를 나중에 추가
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb", "root", "1234");
			System.out.println("DB 연결 완료");
			
			// 등록할 질의
			String sql = "SELECT userID,name,birthYear,addr FROM userTbl WHERE userID = ?";
			pstmt = conn.prepareStatement(sql);
			// <? wildcard> 자리에 데이터 삽입 : ? 배치에 따라 왼쪽에서 부터 1로 시작해 1씩 증가
			// 검색할 사용자 아이디 입력받기
			Scanner sc = new Scanner(System.in);
			System.out.println("검색할 회원의 아이디를 작성해 주세요 > ");
			String id = sc.next();
			
			// 입력받은 아이디 값으로 pstmt의 SQL query문 완성
			pstmt.setString(1,  id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				// primary key는 존재하거나 존재하지 않거나이므로, if 사용
				String userId = rs.getString("userId");
				String name = rs.getString(2);
				int birthYear = rs.getInt(3);
				String addr = rs.getString(4);
				System.out.println(userId+":"+name+":"+birthYear+":"+addr);
				System.out.println("검색완료");
			} else {
				System.out.println(id+"는 존재 하지 않습니다.");
			}
			
			System.out.println("회원 정보 검색");
			rs.close();
			pstmt.close();
			// mobile1, mobile2, height, mDate 수정
			sql = "UPDATE userTbl SET mobile1 = ?, mobile2 = ?, height = ?, mDate = ? WHERE userID = ? ";
			System.out.println(sql);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "010");
			pstmt.setString(2, "63514894");
			pstmt.setString(3, "172");
			Date date = new Date(System.currentTimeMillis()); // 현재 시간의 long 타입으로 매개변수 받음
			pstmt.setDate(4, date);
			pstmt.setString(5, "KGM");
			
			int result = pstmt.executeUpdate();
			System.out.println(result+"개의 행이 수정 되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
			} catch (SQLException e) {}
						
			try {
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {}
			
			try {
				if(conn != null) conn.close();
			} catch (SQLException e) {}
		}
	}
}