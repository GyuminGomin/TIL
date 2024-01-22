<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RESULT</title>
</head>
<body>
	<h1>result.jsp</h1>
	<h3>pageContext : <%=pageContext.getAttribute("index") %></h3>
 	<h3>request : <%=request.getAttribute("index") %></h3>
 	
 	<a href="redirect?id=id001">response send redirect</a> <br/>
 	<hr/>
 	<a href="forward?id=id001">dispatcher forward</a>
</body>
</html>