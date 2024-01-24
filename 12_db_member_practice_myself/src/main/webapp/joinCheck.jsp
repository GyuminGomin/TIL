<%@page import="vo.MemberVO"%>
<%@page import="dao.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
   
<!-- 회원가입 요청 처리 - joinCheck.jsp -->

<%
	// 만약 get 방식으로 요청이 들어오면, 잘못된 접근
	if (request.getMethod().equalsIgnoreCase("get")) {
 %>
	<script>	
		alert('잘못된 접근 방식입니다.');
		history.back();
	</script>
<%
	} else { // POST 방식 요청이 잘 들어오면 회원가입 규칙에 어긋남이 없음
		// DAO 불러오기
		MemberDAO dao = new MemberDAOImpl();
		// DB에 있는 값 저장 후 MemberList 반환 
		List<MemberVO> memberList = dao.selectMemberList();

		// 요청된 파라미터 값 받아오기
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String strAge = request.getParameter("age");
		int age = Integer.parseInt(strAge);
		
		// 먼저 받아올 VO 객체 생성 (받아온 데이터를 기반으로 새로 생성할 VO)
		MemberVO member = new MemberVO(id, pass, name, addr, phone, gender, age);
		
		// id 값 체크
		if (!memberList.isEmpty() && memberList.contains(member)) { // memberList가 비어있지 않고, id가 같은 것이 존재한다면
			// forward 방식으로 화면 전환 후 메시지 전송해줘야 하므로 message를 따로 생성 후 전달
			String message = "중복된 id 입니다. 다시 값을 설정해 주세요.";
			session.setAttribute("message", message); // alert로 알림을 보내주기 위한 메시지
			session.setAttribute("member", member); // member 정보를 넘겨줘서 id만 null로 설정
			response.sendRedirect("join.jsp");
			return;
		}
		
		// DB에 회원정보 넣어주기 (id 값 체크가 문제가 없을 시)
		dao.join(member);
%>
		<script>
			alert('회원가입이 완료되었습니다.');
			location.href='./login.jsp';
		</script>
<%	
	}
%>





