<%@page import="util.*"%>
<%@page import="java.sql.*"%>
<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- qna_write_submit.jsp -->
<%
	// 게시글 등록 요청 처리
	MemberVO member = (MemberVO)session.getAttribute("loginMember");

	String qna_name = member.getName();		// 로그인 된 회원 이름
	int qna_writer_num = member.getNum();	// 로그인 된 회원 번호
	// request에서 전달된 게시글 등록에 필요한 제목, 내용
	String qna_title = request.getParameter("qna_title");
	String qna_content = request.getParameter("qna_content");
	
	Connection conn = JDBCUtil.getConnection();
	PreparedStatement pstmt = null;
	
	String sql = "INSERT INTO qna_board(qna_name, qna_title, qna_content, qna_writer_num) VALUES(?, ?, ?, ?)";
	
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, qna_name);
		pstmt.setString(2, qna_title);
		pstmt.setString(3, qna_content);
		pstmt.setInt(4, qna_writer_num);
		int result = pstmt.executeUpdate();
		
		response.sendRedirect("qna_list.jsp");
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		JDBCUtil.close(pstmt, conn);
	}
%>