<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD COOKIE</title>
</head>
<body>
	<%@ include file="check.jsp" %>
	<hr/>
	<h1>ADD COOKIE</h1>
	<%
	// 쿠키 등록 첫번째 방법
		// Set-Cookie
		// JSESSIONID=2DFFD387CB18C3BBA86CB95F70693FF1; Path=/06_session_cookie;
		// 60 * 60 * 24 * 30 = 2592000 (Max-Age는 초단위)
		response.addHeader("Set-Cookie", "id=id001; Max-Age=2592000; path=/");
	
	// 쿠키 등록 두번째 방법 (일반적으로 이걸 많이 씀)
		// 첫번째 (name-한글이 안됨), 두번째 (value)
		Cookie cookie = new Cookie("PM_NAME","김규민");
		cookie.setMaxAge(2592000);
		cookie.setPath("/");
		response.addCookie(cookie);
	%>
	<a href="index.jsp">메인으로</a>
</body>
</html>