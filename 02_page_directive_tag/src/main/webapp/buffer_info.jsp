<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- buffer="8kb" autoFlush="true" 기존 default -->
<%-- <%@ page buffer = "1kb" autoFlush="false" %> <!-- 1kb 까지만 출력 가능 --> --%>
<%@ page buffer="8kb" autoFlush="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>buffer info</title>
</head>
<body>
	<!-- 전체 버퍼 크기 -->
	Buffer size = <%= out.getBufferSize() %> <br/> <!-- 저장할 수 있는 전체 버퍼 크기 -->
	<!-- 버퍼에 남은 크기, 잔존 양 -->
	Remaining size = <%= out.getRemaining() %> <br/>
	
	<%
		for (int i=0; i<1000; i++) {
			out.println("	1234	");
			int bytes = out.getRemaining();
			out.println("("+bytes+")");
		}
	%>
</body>
</html>