<%@ page pageEncoding="UTF-8"%>
<!-- logOut.jsp -->
<%
	// 인증된 사용자 계정 정보 삭제 - session의 loginMember 속성
	session.removeAttribute("loginMember");
	// session 객체 무효화 // 내부에 있는 모든 속성 데이터 삭제
	// session.invalidate();
	
	// 로그아웃 요청 처리 시 cookie 정보도 삭제
	Cookie cookie = new Cookie("rememberMe", "");
	cookie.setMaxAge(0);
	cookie.setPath("/");
	response.addCookie(cookie);
%>

<script>
	alert('로그아웃 처리 완료');
	location.href='index.jsp';
</script>