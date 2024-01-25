<%@page import="java.util.Base64"%>
<%@page import="vo.MemberVO"%>
<%@page import="java.sql.*"%>
<%@page import="util.JDBCUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!-- 로그인 요청 처리 페이지 - loginCheck.jsp -->

<%
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	
	Connection conn = JDBCUtil.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 처리완료 메시지
	String msg = "";
	// 이동할 페이지
	String nextPage = "";
	
	String sql = "SELECT * FROM test_member WHERE id = ? AND pass = ?";
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pass);
		
		rs = pstmt.executeQuery();
		if (rs.next()) {
			msg = "로그인 성공";
			nextPage = "index.jsp";
			// 로그인 성공 - id,pass 일치 사용자 검색
			// 인증된 정보를 session에 저장할 회원정보 객체
			MemberVO loginMember = new MemberVO(
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
			
			// 로그인 상태 유지 요청
			String login = request.getParameter("login");
			if (login != null) {
				// id 문자열을 byte[] 로 변경
				byte[] bytes = id.getBytes();
				byte[] encodedID = Base64.getEncoder().encode(bytes); // encoding 사용하는 데이터를 부호화 decoding 사용하는 데이터를 해석
				System.out.println("id : " + id);
				id = new String(encodedID);
				System.out.println("encoded id : " + id);
				// 로그인 상태 유지 체크박스 체크 상태
				Cookie cookie = new Cookie("id", id); // id라는 이름으로 value(id) 값을 저장
				// path는 따로 지정하지 않으면 contextPath
				cookie.setMaxAge(60*60*24); // 하루
				response.addCookie(cookie);
			}
		} else {
			// 로그인 실패 - 아이디 패스워드 일치 x
			msg = "로그인 실패";
			nextPage = "login.jsp";
		}
	} catch(Exception e) {
		msg = "로그인 실패-"+e.toString();
		nextPage = "login.jsp";
	} finally {
		JDBCUtil.close(rs, pstmt, conn);
	}
%>

<script>
	alert('<%=msg%>');
	location.replace('<%=nextPage%>');
</script>


