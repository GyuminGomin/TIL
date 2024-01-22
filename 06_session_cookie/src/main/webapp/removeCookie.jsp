<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REMOVE COOKIE</title>
</head>
<body>
	<h1>REMOVE COOKIE</h1>
	<%
		// cookie 정보는 사용자 컴퓨터의 브라우저 정보로 물리적으로 존재하기 때문에 임의로 삭제할 수 없음
		// cookie는 같은 name 이라면, 덮어쓰기를 함
		
	// 첫번째 삭제 방법
		response.addHeader("Set-Cookie", "id=; Max-Age=0; path=/");
	
	// 두번째 삭제 방법
		Cookie cookie = new Cookie("PM_NAME","");
		// path 경로 default 는 contextPath, path가 틀리면 다른 cookie로 인식
		cookie.setPath("/");
		// cookie.setMaxAge(0); // 지정하지 않으면 Session -> 브라우저 종료될 때 삭제
		response.addCookie(cookie);
	%>
	<a href="index.jsp">메인으로</a>
</body>
</html>