<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CHECK SESSION</title>
</head>
<body>
	<%@ include file="check.jsp" %>
	<h1>session check</h1>
	
	<%
		// tomcat server 설정 기본 : 1800 - 30분
		// 프로젝트 설정 10분 - 600초
		// 해당 session의 최대 유지 시간을 초단위로 지정
		// session.setMaxInactiveInterval(60); // 이 페이지로 들어온 session은 1분 유지
	
		int max = session.getMaxInactiveInterval();
		out.println("max inactive : " + max + "<br/>");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		// session 객체 생성 시간을 millis로 변환
		long create = session.getCreationTime();
		String time = sdf.format(create);
		out.println("현재 session 생성 시간 : " + time + "<br/>");
		
		// 현재 session으로 들어온 client의 마지막 요청 시간
		long last = session.getLastAccessedTime();
		time = sdf.format(last);
		out.println("마지막 session 요청 시간 : " + time + "<br/>");
		// session 유지 기간은 마지막 요청 시간으로 부터 새롭게 경신됨
		
		// 해당 session 객체에 등록된 속성 값들중 name 값이 uid인 속성값을 삭제
		// session.removeAttribute("uid");
		
		// session 무효화 (저장되어 있는 모든 세션 name들을 삭제)
		session.invalidate();
		out.println("session id : " + session.getId() + "<br/>"); // 기존에 있던 session 객체 읽어들이긴 가능
		// 무효화된 session 객체에 값을 변경하거나 추가하게 되면 오류 발생
		// session.setAttribute("SessionID", "add session"); // 값 추가는 불가능
	%>
	
	<a href="index.jsp">메인으로</a>
</body>
</html>