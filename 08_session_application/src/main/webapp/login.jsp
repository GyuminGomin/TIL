<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common/header.jsp"%>
<form action="loginCheck.jsp" method="POST">
	<table border=1>
		<thead>
			<tr>
				<th colspan="2">
					<h3>LOGIN PAGE</h3>
				</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="uid" required autocomplete="off"/>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="upw" required/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<label>
						<input type="checkbox" name="rememberMe" /> 로그인 정보 저장
					</label>
				</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<th colspan="2">
					<button>로그인</button>
				</th>
			</tr>
		</tfoot>
	</table>
</form>
<%@ include file="common/footer.jsp"%>