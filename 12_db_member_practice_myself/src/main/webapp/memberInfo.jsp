<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!-- memberInfo.jsp -->
<%@ include file="common/header.jsp" %>

<%
	// id를 받아왔으면 회원 정보 DB에서 탐색
	String id = request.getParameter("id");
	MemberVO member = dao.idCheck(new MemberVO(id)); // id가 같은 회원정보를 저장 후
%>
<section>
<table>
	<tr>
		<th colspan="2">
		</th>
	</tr>
	<tr>
		<td>아이디</td>
		<td><%=member.getId() %></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><%=member.getName() %></td>
	</tr>
	<tr>
		<td>주소</td>
		<td><%=member.getAddr() %></td>
	</tr>
	<tr>
		<th colspan="2">
			<a href="./memberUpdateForm.jsp?id=<%=id%>">수정</a> | <a href="./memberDelete.jsp?id=<%=id%>">삭제</a>
		</th>
	</tr>
</table>
</section>
<%@ include file="common/footer.jsp" %>











