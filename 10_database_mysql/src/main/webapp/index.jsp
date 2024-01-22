<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
</head>
<body>
	<!-- index.jsp -->

	<%
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/develop_jsp";
		String username = "developer";
		String password = "1234";
		// JDBC - 객체는 java.sql 패키지에 존재
		Connection conn = null;
		
		try {
			Class.forName(driver);
			out.println("Driver Class가 존재합니다. <br/>");
			conn = DriverManager.getConnection(
				url, username, password
			);
			out.println("DB 연결 완료 : ");
			out.println(conn + "<br/>");
		} catch(ClassNotFoundException e) {
			out.println("Driver Class를 찾을 수 없습니다. <br/>");
		} catch(SQLException e) {
			out.println("연결 요청 정보 오류 : " + e.toString());
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	%>
	<h1> MAIN PAGE </h1>
	<h3><a href="insertForm.jsp">회원정보 입력</a></h3>
	<h3><a href="memberList.jsp">회원목록</a></h3>
</body>
</html>

