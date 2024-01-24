<%@page import="vo.MemberVO"%>
<%@page import="dao.MemberDAOImpl"%>
<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- memberDelete.jsp -->

<%
	// 삭제 회원 선택 후 삭제
	MemberDAO dao = new MemberDAOImpl();

	// 파라미터 받아오기
	String id = request.getParameter("id");
	
	// 아이디 체크 후 가져오기
	MemberVO member = dao.idCheck(new MemberVO(id));
	
	// 회원 삭제
	dao.delete(member);
	
	%>
	<script>
		alert('회원삭제 완료');
		location.href='./memberList.jsp';
	</script>
	<%
%>










