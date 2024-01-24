<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- logout.jsp -->

<%
	// 로그아웃
	session.removeAttribute("loginMember");
	// 로그아웃 시 쿠키 정보 삭제
	Cookie cookie = new Cookie("id", "");
	cookie.setMaxAge(0);
	cookie.setPath("/");
	response.addCookie(cookie);
%>
	<script>
	alert('로그아웃 성공');
	location.href='./index.jsp';
	</script>