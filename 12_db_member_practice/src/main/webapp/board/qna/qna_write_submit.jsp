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
	ResultSet rs = null;
	
	String sql = "INSERT INTO qna_board(qna_name, qna_title, qna_content, qna_writer_num) VALUES(?, ?, ?, ?)";
	
	try {
		// 개발자가 transaction 제어 - commit or rollback;
		conn.setAutoCommit(false); // 지금 연결된 conn은 autoCommit을 사용하지 않겠다. ( 기본값은 true )
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, qna_name);
		pstmt.setString(2, qna_title);
		pstmt.setString(3, qna_content);
		pstmt.setInt(4, qna_writer_num);
		pstmt.executeUpdate();
		
		JDBCUtil.close(pstmt);
		
		sql = "SELECT LAST_INSERT_ID()";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		int qna_num = 0;
		if (rs.next()) {
			qna_num = rs.getInt(1);
		}
		
		JDBCUtil.close(rs, pstmt);
		sql = "UPDATE qna_board SET qna_re_ref = ? WHERE qna_num = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, qna_num);
		pstmt.setInt(2, qna_num);
		int result = pstmt.executeUpdate();
		if (result == 1) {
			conn.commit(); // commit 과 rollback이 있어야지 무조건 락 걸린 상태를 해제할 수 있다.
		} else {
			conn.rollback();
		}
		
		response.sendRedirect("qna_list.jsp");
	} catch (Exception e) {
		e.printStackTrace();
		conn.rollback();
	} finally {
		conn.setAutoCommit(true); // 다음 사용되는 녀석을 위해 transaction 제어 상태를 (TCL) true로 되돌림
		JDBCUtil.close(pstmt, conn);
	}
%>