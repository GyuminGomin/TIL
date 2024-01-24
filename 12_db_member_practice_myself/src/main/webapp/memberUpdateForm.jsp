<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common/header.jsp" %>
<section>
<!-- memberUpdateForm.jsp -->
<%
	// id를 받아왔으면 회원 정보 DB에서 탐색
	String id = request.getParameter("id");
	MemberVO member = dao.idCheck(new MemberVO(id)); // id가 같은 회원정보를 저장 후
%>

<script type="text/javascript" src="js/inputCheck.js"></script>
<form action="memberUpdate.jsp?idc=<%=id %>" method="POST">
	<table>
		<tr>
			<th colspan="2"><h1>회원정보 수정</h1></th>
		</tr>
		<tr>
			<td>아이디</td>
			<td>
				<input type="text" name="id" data-msg="아이디" value="<%=member.getId() %>"/>
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>
				<input type="password" name="pass" data-msg="비밀번호" value="<%=member.getPass() %>"/>
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>
				<input type="text" name="name" data-msg="이름" value="<%=member.getName() %>"/>
			</td>
		</tr>
		<tr>
			<td>주소</td>
			<td>
				<input type="text" name="addr" data-msg="주소" value="<%=member.getAddr() %>"/>
			</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>
				<input type="text" name="phone" data-msg="전화번호" value="<%=member.getPhone() %>"/>
			</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
				<label>
				<input type="radio" name="gender" value="남성" <%=member.getGender().equals("남성") ? "checked" : "" %>/>
				남성
				</label>
				<label>
				<input type="radio" name="gender" value="여성" <%=member.getGender().equals("여성") ? "checked" : "" %>/>
				여성
				</label>
			</td>
		</tr>
		<tr>
			<td>나이</td>
			<td>
				<input type="number" name="age" data-msg="나이" value="<%=member.getAge() %>" />
			</td>
		</tr>
		<tr>
			<th colspan="2">
				<button>회원 정보 수정</button>
			</th>
		</tr>
	</table>
</form>
</section>
<%@ include file="common/footer.jsp" %>









