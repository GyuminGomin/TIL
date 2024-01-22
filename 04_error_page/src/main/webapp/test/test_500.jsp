<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TEST 500</title>
</head>
<body>
	<%
		if(request.getParameter("aa") == null) {
			throw new ClassNotFoundException("없는 경로");
		} /* 중요 에러를 발생시키면 500 에러를 발생시켜줄 수 있음 */ /* directory tag로 설정된 errorPage가 우선순위가 더 높음 */
	%>
</body>
</html>