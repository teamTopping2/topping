<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>topping</title>
</head>
<body>
<% if(exception != null){  //jsp 페이지에서 발생한 에러일 때 %>
<h3>jsp 페이지 오류 : <%= exception.getMessage() %></h3>	
<% }else{ %> 
<h3><%= request.getAttribute("message") %></h3>
<% } %>
<a href="/topp/index.jsp">홈화면으로 돌아가기</a>
</body>
</html>