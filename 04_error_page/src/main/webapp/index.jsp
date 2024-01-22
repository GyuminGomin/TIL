<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<a href="test/page_error.jsp?aa=삼">page error</a> <br/>
	<a href="test/test_500.jsp">500 Test</a> <br/>
	<a href="test/wow.jsp?id=matriachal">404 Test</a> <br/>
	<a href="test/test_405.jsp">405 GET TEST</a> <!-- test405 get 요청 -->
	<form action="test/test_405.jsp" method="POST"> <!-- test405 post 요청 -->
		<input type="number" /> <!-- name="age" --> <!-- 값을 넣어주지 않으면 null이 아닌 "" -->
		<button>전송</button>
	</form>
</body>
</html>