<%@page import="dao.MemberDAO"%>
<%@page import="dao.MemberDAOImpl"%>
<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	// 자동로그인 처리를 위해 dao 생성
	MemberDAO dao = new MemberDAOImpl();
	// session 값 불러오기
	MemberVO loginMember = (MemberVO)session.getAttribute("loginMember");
	// 자동 로그인 체크시
	// request로 전달된 브라우저의 쿠키 목록
	Cookie[] cookies = request.getCookies();
	// 비로그인 상태에서 쿠키 정보가 전달 되면 자동로그인 작업 수행
	if (loginMember == null && cookies != null) {
		for (Cookie c : cookies) {
			String name = c.getName(); // id로 저장함
			String value = c.getValue(); // id001 같은 정보
			if (name.equals("id")) { // 존재한다면 자동 로그인 설정 함
				// 등록된 회원 목록에서 id값(value)이 일치하는 사용자 검색
				// 일단 회원정보를 받아와서
				MemberVO m = new MemberVO(value);
				// 존재하는 회원을 반환
				loginMember = dao.idCheck(m); // 회원이 없는 상태라면 null을 반환
				if (loginMember != null) {
					session.setAttribute("loginMember", loginMember);
				} // TODO 일단 회원이 존재할 때 자동 로그인 (회원탈퇴를 누르지 않았기에)
			}
		}
	}
%>	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<link href="css/header.css" rel="stylesheet" type="text/css" />
<link href="css/footer.css" rel="stylesheet" type="text/css" />
<link href="css/common.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<header>
		<div>
			<ul>
				<li><a href="index.jsp">home</a></li>
				<%
				if (loginMember == null) {
				%>
				<!-- 비 로그인시용자 -->
				<li><a href="login.jsp">로그인</a></li>
				<li><a href="join.jsp">회원가입</a></li>
				<%} else {%>
				<!-- 로그인 된 사용자 -->
				<li><a href="info.jsp"> <%=loginMember.getName() %>
				</a>님 방가방가</li>
				<% 
					if (loginMember.equals(new MemberVO("admin"))) { // 로그인한 회원이 admin이라면
				%>
						<!-- 관리자 로그인일 경우 -->
						<li><a href="memberList.jsp">회원관리</a></li>
				<%
					}
				%>
				<li><a href="logout.jsp">로그아웃</a></li>
				<%}%>
				
				
			</ul>
		</div>
		<div>
			<ul>
				<li><a href="#">공지사항</a></li>
				<li><a href="#">질문과답변</a></li>
			</ul>
		</div>
	</header>