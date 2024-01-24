<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common/header.jsp"%>
<section>
	<table>
		<tr>
			<th colspan="2"><h1>회원정보</h1></th>
		</tr>
		<tr>
			<td>아이디</td>
			<td>
				<%=loginMember.getId() %>
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>
				<%=loginMember.getName() %>
			</td>
		</tr>
		<tr>
			<td>주소</td>
			<td>
				<%=loginMember.getAddr() %>
			</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>
				<%=loginMember.getPhone() %>
			</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
				<input type="radio" <%=loginMember.getGender().equals("남성") ? "checked" : "disabled" %>/> 남성 
				<input type="radio" <%=loginMember.getGender().equals("여성") ? "checked" : "disabled" %>/> 여성
			</td>
		</tr>
		<tr>
			<td>나이</td>
			<td>
				<%=loginMember.getAge() %>
			</td>
		</tr>
		<tr>
			<th colspan="2">
				<button type="button" onclick="location.href='./index.jsp';">메인으로</button>
			</th>
		</tr>
	</table>
</section>
<%@ include file="common/footer.jsp"%>























