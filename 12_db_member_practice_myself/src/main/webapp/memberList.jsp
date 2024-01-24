<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!-- memberList.jsp -->
<%@ include file="common/header.jsp" %>

<%
	// 이미 header에 dao가 존재하므로
	List<MemberVO> memberList = dao.selectMemberList();
%>
<section>
<table border=1 class="list">
	<tr>
		<th colspan="7"><h1>회원목록</h1></th>
	</tr>
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>이름</th>
		<th>주소</th>
		<th>전화번호</th>
		<th>성별</th>
		<th>나이</th>
	</tr>
	<!-- 회원 목록 출력 -->
	<% 
	for (MemberVO m : memberList) { %>
	<tr onClick="location.href='memberInfo.jsp?id=<%=m.getId() %>';" title="회원정보 수정<%=m.getNum() %>">
		<td><%=m.getNum() %></td>
		<td><%=m.getId() %></td>
		<td><%=m.getName() %></td>
		<td><%=m.getAddr() %></td>
		<td><%=m.getPhone() %></td>
		<td><%=m.getGender() %></td>
		<td><%=m.getAge() %></td>
	</tr>
	<%}%>
	
	<!-- 등록된 회원이 없을 시 출력 -->
	<%if (memberList.isEmpty()) { // 회원정보가 비어 있다면 %>
	<tr><th colspan="7">등록된 회원이 없습니다.</th></tr>
	<%}%>
</table>
</section>
<%@ include file="common/footer.jsp" %>











