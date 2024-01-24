<%@page import="vo.MemberVO"%>
<%@page import="dao.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!-- 로그인 요청 처리 페이지 - loginCheck.jsp -->

<%
	// dao 정보 가져오기
	MemberDAO dao = new MemberDAOImpl();
	
	//파라미터 가져오기
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String login = request.getParameter("login");
	
	// Member 생성 (Id와 Pass 만 존재)
	MemberVO m = new MemberVO(id,pass);

	// Id, pass 일치 시 로그인 성공 실패시 null 반환
	MemberVO member = dao.login(m);
	
	// 로그인 성공
	if (member != null) {
		// 세션에 회원 정보를 저장
		session.setAttribute("loginMember", member);
		// 만약 자동 로그인 클릭시
		if (login != null) {
			Cookie cookie = new Cookie("id", member.getId());
			cookie.setMaxAge(60*60*24*15); // 15일 동안 유지
			cookie.setPath("/"); // 서버의 모든 경로에서 사용
			response.addCookie(cookie);
		}
%>
		<script>
		alert('로그인 성공');
		location.href='./index.jsp';
		</script>
<%
	} else {
%>
		<script>
		alert('로그인 실패, id와 pass를 확인해주세요');
		history.go(-1);
		</script>
<%
	}

	
%>




