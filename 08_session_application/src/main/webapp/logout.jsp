<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	session.removeAttribute("loginMember");
	
	// 사용자 pc에 저장된 쿠키 정보 삭제
	Cookie cookie = new Cookie("uid", "");
	cookie.setMaxAge(0);
	cookie.setPath("/");
	response.addCookie(cookie);
%>
<script>
	alert('로그아웃 완료');
	location.href='main.jsp'; // location : 주소 표시줄 정보를 저장하고 있는 것
</script>