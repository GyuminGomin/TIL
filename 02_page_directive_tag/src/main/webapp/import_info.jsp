<%-- <%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%> --%>
<%@ page import="java.util.*, java.text.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>import info</title>
</head>
<body>
	<%
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = sdf.format(new Date());
		out.println(date+"<br/>");
	%>
	
	<%@ page info="Date 클래스를 이용한 날짜 출력하기" %>
	<!-- Servlet 정보 -->
	<!-- Jasper JSP 3.1 엔진 -->
	<%= getServletInfo() %>
</body>
</html>