<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
</head>
<body>
<h1>오류 발생</h1>
<%-- jsp 내장 객체 중 exception 객체 사용 
		page 지시자 태그에 isErrorPage = "true"로 지정된 페이지에서만 사용 가능--%>
		
<% if(exception != null) { // jsp 페이지에서 발생한 에러일 때 %>
<h3>jsp 페이지 오류 : <%= exception.getMessage() %></h3>
<% } else { %>
<h3>servlet 메세지: <%= request.getAttribute("message") %></h3>
<% } %>
<a href = "/first/index.jsp">시작페이지로 가기</a>
</body>
</html>



