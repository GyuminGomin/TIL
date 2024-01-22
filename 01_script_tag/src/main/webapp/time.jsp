<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 선언부 -->
<%!
	private String s = "test";
	private int count = 0;
	
	public String getText(String str) {
		s += str;
		count++;
		return s;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트 태그</title>
</head>
<body>
	<h1>Time JSP</h1>
	<%
		out.println(getText("하하호호"));
		SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-mm-dd hh:mm:ss"
		);
		String date = sdf.format(new Date());
	%>
	<br/>
	
	현재 시간 : <%= date %> <br/>
	
	<%= getText("하하호호") %>
	<%= count %>
</body>
</html>