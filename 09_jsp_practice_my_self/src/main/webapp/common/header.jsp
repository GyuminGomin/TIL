<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// loginMember로 등록된 정보가 존재하면 인증이 완료된 사용자
	MemberVO loginMember = (MemberVO)session.getAttribute("loginMember");    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
<link href="css/common.css" rel="stylesheet" type="text/css">
</head>
<body>
	<header>
		 <ul>
		 	<li><a href="index.jsp">HOME</a></li>
		 	<% if (loginMember != null) { %>
			<!-- 로그인 상태 -->
			<li><a href="info.jsp"> <%=loginMember.getName()%> </a>님 반갑습니다.</li>
			<li><a href="logOut.jsp">로그아웃</a></li>
			<% } else { %>
			<!-- 비 로그인 상태 -->
		 	<li><a href="login.jsp">로그인</a></li>
		 	<li><a href="join.jsp">회원가입</a></li>
		 	<% } %>
		 </ul>
		 
	 	<%
			String message = (String)request.getAttribute("message");
			if (message != null) {
		%>
			<script>
				alert("<%=message%>");
			</script>
		<% } %>
 </header>
 
 
 
 
 
 