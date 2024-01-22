<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="common/header.jsp" %>
    <main>
    	<article>
    		<h1>MAIN 본문</h1>
    	</article>
    	<section>
    		<%@ include file="content.jsp" %>
    		<%! String result = "본문에서 선언된 필드"; %>
    		<h3><%= s %></h3>
    		<%= result %>
    	</section>
    </main>
<%@ include file="common/footer.jsp" %>