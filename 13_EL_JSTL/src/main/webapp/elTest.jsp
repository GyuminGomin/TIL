<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- elTest.jsp -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>elTest.jsp</title>
</head>
<body>
	EL SESSION : ${member} <br/>
	<%
		String id = request.getParameter("id");
		request.setAttribute("userID", id);
	%>
	request ID : ${userID} <br/> 
	<input type="text" value="${param.id}" />
</body>
</html>