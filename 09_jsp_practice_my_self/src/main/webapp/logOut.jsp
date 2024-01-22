<%@ page pageEncoding="UTF-8"%>
<!-- logOut.jsp -->
<%
	session.removeAttribute("loginMember");
	Cookie cookie = new Cookie("id", "");
	cookie.setMaxAge(0);
	cookie.setPath("/");
	response.addCookie(cookie);
%>

<script>
	alert('로그아웃 완료');
	location.href='index.jsp'; // location : 주소 표시줄 정보를 저장하고 있는 것
</script>