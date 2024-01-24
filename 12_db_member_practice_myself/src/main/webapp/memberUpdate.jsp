<%@page import="vo.MemberVO"%>
<%@page import="dao.MemberDAOImpl"%>
<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- memberUpdate.jsp -->

<%
	// 회원정보 수정을 위한 dao 가져오기
	MemberDAO dao = new MemberDAOImpl();

	//요청된 파라미터 값 받아오기
	String idc = request.getParameter("idc");
	
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String name = request.getParameter("name");
	String addr = request.getParameter("addr");
	String phone = request.getParameter("phone");
	String gender = request.getParameter("gender");
	String strAge = request.getParameter("age");
	int age = Integer.parseInt(strAge);
	
	// 회원 num 가져오기
	MemberVO m = dao.idCheck(new MemberVO(idc));
	int num = m.getNum();
	
	// 수정할 회원 객체 설정 후 수정
	MemberVO member = new MemberVO(num, id, pass, name, addr, phone, gender, age);
	dao.update(member);
	
	%> 
	<script>
		alert('수정 완료');
		location.href='./memberList.jsp';
	</script>
	<%
%>









