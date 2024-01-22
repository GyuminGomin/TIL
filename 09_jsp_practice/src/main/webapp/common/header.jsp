<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 사용자가 로그인된 상태인지를 session의 loginMember 속성값으로 판별
	MemberVO loginMember = (MemberVO)session.getAttribute("loginMember");

	// TODO cookie 정보를 이용한 자동 로그인 기능 추가
%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/common.css" rel="stylesheet" type="text/css">
</head>
<body>
	<header>
		 <ul>
		 	<li><a href="index.jsp">HOME</a></li>
		 	<!-- session에 loginMember 속성값이 존재 -->
		 	<% if(loginMember != null) { %>
			<!-- 로그인 상태 -->
			<li><a href="info.jsp"> <%=loginMember.getName() %> </a>님 반갑습니다.</li>
			<li><a href="logOut.jsp">로그아웃</a></li>
			<% } else { %>
			<!-- 비 로그인 상태 -->
		 	<li><a href="login.jsp">로그인</a></li>
		 	<li><a href="join.jsp">회원가입</a></li>
		 	<% } %>
		 </ul>
 </header>
 
 
 
 
 
 