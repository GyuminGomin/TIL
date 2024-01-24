<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common/header.jsp" %>
<script type="text/javascript" src="js/inputCheck.js"></script>
<section>
<form action="joinCheck.jsp" method="POST">
	<table>
		<tr>
			<th colspan="2"><h1>회원가입</h1></th>
		</tr>
		<tr>
			<td>아이디</td>
			<td>
				<input type="text" id="id" name="id" data-msg="아이디" required/>
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>
				<input type="password" id="pass" name="pass" data-msg="비밀번호" required/>
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>
				<input type="text" id="name" name="name" data-msg="이름" required/>
			</td>
		</tr>
		<tr>
			<td>주소</td>
			<td>
				<input type="text" id="addr" name="addr" data-msg="주소" required/>
			</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>
				<input type="text" id="phone" name="phone" data-msg="전화번호" required/>
			</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
				<label>
				<input type="radio" name="gender" value="남성" checked />
				남성
				</label>
				<label>
				<input type="radio" name="gender" value="여성" />
				여성
				</label>
			</td>
		</tr>
		<tr>
			<td>나이</td>
			<td>
				<input type="number" id="age" name="age" data-msg="나이" required/>
			</td>
		</tr>
		<tr>
			<th colspan="2">
				<button>회원가입</button>
			</th>
		</tr>
	</table>
</form>
</section>
<!-- join.jsp -->
<%
	// 기본적으로 회원가입시 message, member는 쓰이지 않음 
	String message = null;
	MemberVO member = null;

	// id가 중복 될 때, 넘어오는 정보
	message = (String)session.getAttribute("message");
	member = (MemberVO)session.getAttribute("member");
	
	if(member != null && message != null) { // 따라서 null 일때는 실행되지 않음
	%>
		<script>
		let msg = '<%=message%>';
		alert(msg);
		
		let memberId = document.getElementById("id"); // id를 받아와서 설정 바꿔주기
		let memberPass = document.getElementById("pass");
		let memberName = document.getElementById("name");
		let memberAddr = document.getElementById("addr");
		let memberPhone = document.getElementById("phone");
		// 성별 처리는 일단 하지말자 감이 안 잡힌다.
		let memberAge = document.getElementById("age");
		memberId.value = '';
		memberPass.value = '';
		memberName.value = '<%=member.getName() %>';
		memberAddr.value = '<%=member.getAddr() %>';
		memberPhone.value = '<%=member.getPhone() %>';
		memberAge.value = '<%=member.getAge() %>';
		</script>	
	<%
		// 한번 실행하고 나면 session 정보 초기화
		session.removeAttribute("message");
		session.removeAttribute("member");
		// session.invalidate();
	}
%>


<%@ include file="common/footer.jsp" %>








