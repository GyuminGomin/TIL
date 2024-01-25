<%@page import="java.util.Base64"%>
<%@page import="vo.MemberVO, java.sql.*, util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error/error_400.jsp"%>

<%
	MemberVO loginMember = (MemberVO)session.getAttribute("loginMember");
	Cookie[] cookies = request.getCookies(); // 쿠키는 브라우저에서 request로 요청을 보내준다.
	if (loginMember == null && cookies != null) {
		// 로그인이 되어 있지 않은 사용자 && 쿠키 정보 존재
		for (Cookie c : cookies) {
			if (c.getName().equals("id")) {
				// 자동 로그인 용으로 등록된 cookie가 존재한다면
				String id = c.getValue(); // 자동로그인 용으로 등록된 사용자 id
				System.out.println("header cookie id : " + id); // 현재는 부호화 되어있음
				byte[] decodedID = Base64.getDecoder().decode(id.getBytes()); // 디코딩
				id = new String(decodedID); // 디코딩된 바이트 배열로 문자열 생성
				System.out.println("header cookie id : " + id); // 복호화
				// 사용자 id로 회원 정보 검색
				Connection conn = JDBCUtil.getConnection();
				String sql = "SELECT * FROM test_member WHERE id = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					loginMember = new MemberVO(
						rs.getInt(1),		// num
						rs.getString(2),	// id
						rs.getString(3),	// pass
						rs.getString(4),	// name
						rs.getString(5),	// addr
						rs.getString(6),	// phone
						rs.getString(7),	// gender
						rs.getInt(8)		// age
					);
					session.setAttribute("loginMember", loginMember);
				} // end rs.next()
				JDBCUtil.close(rs, pstmt, conn);
				break; // cookie를 더이상 체크할 필요가 없으므로 for문 탈출 (기본적으로 쿠키 데이터는 많이 있을 수 있으므로)
			} // end check cookie
		} // end cookies
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
				<% if(loginMember == null) { %>
				<!-- 비 로그인시용자 -->
				<li><a href="login.jsp">로그인</a></li>
				<li><a href="join.jsp">회원가입</a></li>
				<%} else {%>
				<!-- 로그인 된 사용자 -->
				<li><a href="info.jsp"> <%=loginMember.getName() %> </a>님 방가방가</li>
				<li><a href="logout.jsp">로그아웃</a></li>
				<!-- 관리자 로그인일 경우 -->
					<% if(loginMember.getId().equals("admin")) { %>
				<li><a href="memberList.jsp">회원관리</a></li>
					<%}%>
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