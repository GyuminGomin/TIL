<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- qna_detail.jsp -->
<%@ include file="/common/header.jsp" %>
<%@ page import="java.sql.*, vo.*, util.*" %>
<%
	// 상세보기 요청한 게시글 번호
	String qnaNum = request.getParameter("qna_num");
	int qna_num = Integer.parseInt(qnaNum);
	
	Connection conn = JDBCUtil.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "SELECT * FROM qna_board WHERE qna_num = ?";
	
	// 검색된 게시글 정보를 저장할 class
	BoardVO board = null;
	
	try{
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, qna_num);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			board = new BoardVO(
				rs.getInt(1),			// qna_num	
				rs.getString(2),		// qna_name
				rs.getString(3),		// qna_title
				rs.getString(4),		// qna_content
				rs.getInt(5),			// qna_writer_num
				rs.getInt(6),			// qna_count
				rs.getTimestamp(7)		// qna_date
			);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		JDBCUtil.close(rs, pstmt, conn);
	}
%>
<section>
	<table>
		<tr>
			<th colspan="2">
				<h1>게시물 상세 내용</h1>
			</th>
		</tr>
		<tr>
			<td>작성자</td>
			<td><%=board.getQna_name() %></td>
		</tr>
		<tr>
			<td>글 제목</td>
			<td><%=board.getQna_title() %></td>
		</tr>
		<tr>
			<td>글 내용</td>
			<td><pre><%=board.getQna_content() %></pre></td>
		</tr>
		<tr>
			<td>글 작성시간</td>
			<td><%=board.getQna_date() %></td>
		</tr>
		<tr>
			<th colspan="2">
			<!-- 로그인 상태 일 때 -->
				<%if (loginMember != null) { %>
					<%if (loginMember.getNum() == board.getQna_writer_num()) { %>
						<!-- 로그인 된 회원과 게시글 작성한 회원의 번호 일치 -->
						<a href="qna_update.jsp?qna_num=<%=board.getQna_num()%>">[수정]</a>
						<a href="qna_delete.jsp?qna_num=<%=board.getQna_num()%>">[삭제]</a>
					<%} %>
				<%} %>
				<a href="qna_list.jsp">[목록]</a>
			</th>
		</tr>
	</table>
</section>
<%@ include file="/common/footer.jsp" %>