<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- elForm.jsp -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>elForm.jsp</title>
</head>
<body>
	<h1>EXPRESSION LANGUAGE - 표현언어</h1>
	<h3>pageContext &lt; request &lt; session &lt; application</h3>
	<h2>
		4대 영역 객체의 속성값을 JSP page내에서 쉽게 연산하고 읽어서 출력할 수 있도록 구성된 언어
	</h2>
<%
	pageContext.setAttribute("scopeName", "pageContext 영역");
	request.setAttribute("scopeName", "request 영역");
	session.setAttribute("scopeName", "session 영역");
	application.setAttribute("scopeName", "application 영역");
%>
<hr/>
page 영역 : <%= pageContext.getAttribute("scopeName") %> <br/>
request 영역 : <%= request.getAttribute("scopeName") %> <br/>
session 영역 : <%= session.getAttribute("scopeName") %> <br/>
application 영역 : <%= application.getAttribute("scopeName") %> <br/>

<h3>EL 표현식 - \${영역객체.속성 key}</h3>
page EL : ${pageScope.scopeName} <br/>
request EL : ${requestScope.scopeName} <br/>
session EL : ${sessionScope.scopeName} <br/>
application EL : ${applicationScope.scopeName} <br/>
<br/>
<% pageContext.removeAttribute("scopeName"); %>
session EL : ${sessionScope.scopeName} <br/> <!-- pageContext는 모든 영역객체를 포함하고 있으므로 삭제하면 모든 것이 삭제된다. -->
EL scopeName : ${scopeName} <br/>

<% session.setAttribute("member", "김규민"); %>
EL member : ${member} <br/>
findAttribute : <%= pageContext.findAttribute("member") %> <br/> <!-- find는 page, request, session, application 전부를 찾는다. -->
<hr/>
<form action="elTest.jsp">
	<input type="text" name="id" />
	<button type="submit">확인</button>
</form>
<br/>
<br/>
<br/>
<br/>
<br/>
</body>
</html>