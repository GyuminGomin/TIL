<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="connection.jsp" %>

<%
	String strNum = request.getParameter("num");
	int num = 0;
	try {
		num = Integer.parseInt(strNum);
	} catch (Exception e) {
		// 400 : bad_request
		// 이 응답은 잘못된 문법으로 인해 서버가 요청을 이해할 수 없음을 의미
		response.sendError(400, "잘못된 요청입니다.");
		return;
	}
	
	String sql = "SELECT * FROM member WHERE num = ?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, num);
	ResultSet rs = pstmt.executeQuery();
	String name = "";
	String addr = "";
	
	if (rs.next()) {
		name = rs.getString("name");
		addr = rs.getString("addr");
	} 
	if (rs != null) rs.close();
	if (pstmt != null) pstmt.close();
	if (conn != null) conn.close();
	
	if (name.equals("")) {
		response.sendError(400, "요청한 회원정보가 존재하지 않습니다.");
		return;
	}
	
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정 페이지</title>
</head>
<body>
	<!-- updateForm.jsp -->
	<h3><%=strNum %>번 회원정보 수정</h3>
	<form action="updateExecute.jsp" method="POST">
		<input type="hidden" name="num" value="<%=num %>" />
		<table border="1">
			<tr>
				<td>이름</td>
				<td>
					<input type="text" name="name" value="<%=name %>" required />
				</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>
					<input type="text" name="addr" value="<%=addr %>" required />
				</td>
			</tr>
			<tr>
				<th colspan="2">
					<button>등록</button>
				</th>
			</tr>
		</table>
	</form>
</body>
</html>