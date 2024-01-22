<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REQUEST TEST</title>
</head>
<body>
	
	<!-- 
		POST 방식으로 전달될 때만 enctype
		
		enctype - 전송되는 데이터의 인코딩 설정
		application/x-www/form-urlencoded
		- 기본값 : 전송되는 모든 문자들을 서버로 보내기 전에 인코딩 됨을 명시
		
		multipart/form-data (파일 업로드)
		전달되는 데이터에 이전 데이터가 포함 되어 있으므로 모든 문자를 인코딩 하지 않음을 명시
		이 방식은 문자가 아닌 데이터(파일, 이미지) 등을 서버에 전송할 때 사용
		
		text/plain (공백을 표시하기 위해 - 자주 쓰이진 않음)
		일반 문자 - 공백은 '+' 기호로 변환
		나머지 문자는 인코딩 되지 않음
	 -->

	<form action="requestResult.jsp" method="POST" enctype="application/x-www/form-urlencoded">
		이름 : <input type="text" name="name" /> <br/>
		성별 : <input type="radio" name="gender" value="male" checked /> 남
			<input type="radio" name="gender" value="female" /> 여 <br/>
		취미 : <input type="checkbox" name="hobby" value="축구" /> 축구
			<input type="checkbox" name="hobby" value="JAVA" /> 자바
			<input type="checkbox" name="hobby" value="JSP" /> JSP
			<input type="checkbox" name="hobby" value="기타" /> 기타 <br/>
			<input type="submit" /> <!-- submit 버튼 value 지정하면 기본값 제출 -->
	</form>
</body>
</html>