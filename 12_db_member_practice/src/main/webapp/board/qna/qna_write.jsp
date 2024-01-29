<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- qna_write.jsp -->
<%@ include file="/common/header.jsp"%>
<section>
	<form action="qna_write_submit.jsp" method="POST">
		<table>
			<tr>
				<th colspan="2"><h1>질문 작성</h1></th>
			</tr>
			<tr>
				<td>작성자</td>
				<td>
					<input type="text" name="qna_name" value="<%=loginMember.getName()%>" readonly />
				</td>
			</tr>
			<tr>
				<td>글 제목</td>
				<td>
					<input type="text" name="qna_title" required autofocus style="width:90%;"/>
				</td>
			</tr>
			<tr>
				<td>글 내용</td>
				<td>
					<textarea name="qna_content" required cols="50" rows="10"> </textarea>
				</td>
			</tr>
			<tr>
				<th colspan="2">
					<button>작성 완료</button>
					<button type="reset">새로 작성</button>
				</th>
			</tr>
		</table>
	</form>
</section>
<%@ include file="/common/footer.jsp"%>