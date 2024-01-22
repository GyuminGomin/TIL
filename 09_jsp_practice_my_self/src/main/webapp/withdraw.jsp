<%@page import="java.util.ArrayList"%>
<%@page import="vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!-- withdraw.jsp -->



<%
	MemberVO loginMember = (MemberVO)session.getAttribute("loginMember");
	List<MemberVO> memberList = (List<MemberVO>)application.getAttribute("memberList");
	for (MemberVO m : memberList) {
		if (m.equals(loginMember)) {
			memberList.remove(loginMember);
			session.removeAttribute("loginMember");
			Cookie cookie = new Cookie("id", "");
			cookie.setMaxAge(0);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
	}
%>

<script>
	alert('회원 탈퇴 완료');
	location.href='index.jsp'; // location : 주소 표시줄 정보를 저장하고 있는 것
</script>


