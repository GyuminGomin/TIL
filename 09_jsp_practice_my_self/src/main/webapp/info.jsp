<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- info.jsp -->
<%@ include file="common/header.jsp" %>
<section>
 	<table>
 		<tr>
 			<td colspan="2"><h1>회원정보</h1></td>
 		</tr>
 		<tr>
 			<td>아이디</td>
 			<td>
 				<%=loginMember.getId() %>
			</td>
 		</tr>
 		<tr>
 			<td>비밀번호</td>
 			<td>
 				<%=loginMember.getPass() %>
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
 				<% if (loginMember.getGender().equals("남성")) { %>
 				<label>
 					<input type="radio" checked disabled/> 남성
 				</label>
 				<label>
 					<input type="radio" disabled/> 여성
 				</label>
 				<% } else { %>
 				<label>
 					<input type="radio" disabled/> 남성
 				</label>
 				<label>
 					<input type="radio" checked disabled/> 여성
 				</label>
 				<% } %>
 			</td>
 		</tr>
 		<tr>
 			<td>나이</td>
 			<td>
 				<%=loginMember.getAge() %>
 			</td>
 		</tr>
 		<tr>
 			<td colspan="2">
 				<button onclick="location.href='index.jsp';">메인으로</button> 
				 <button onclick="withdraw();">회원탈퇴</button> 
 			</td>
 		</tr>
 	</table>	
</section>
<script>
	function withdraw(){
		let result = confirm("정말로 탈퇴 하시겠습니까?");	
		if(result){
			location.href="withdraw.jsp";	
		}
	}
</script>
<%@ include file="common/footer.jsp" %>










 	
 	
 	
 	
 	
 	