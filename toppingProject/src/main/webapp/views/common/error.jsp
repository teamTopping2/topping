<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
<style type="text/css">
#wrap {
	width: fit-content;
	min-width: 1230px;
	height: 500px;
	margin: 0 auto;
}
</style>
</head>
<body>
	<header>
		<%@ include file="/views/common/menubar.jsp"%>
	</header>
	<div id="wrap">
		<div class="errors"
			style="display: flex; width: 800px; margin: 0 auto; margin-top: 150px;">
			<img src="/topp/resources/images/404-error.png"
				style="width: 200px; height: 200px; float: left;">
			<div>
				<h2
					style="text-align: center; float: left; margin-top: 50px; margin-left: 30px;">현재
					페이지에 오류가 발생하였습니다.</h2>
				<%-- jsp 내장 객체 중 exception 객체 사용 
		page 지시자 태그에 isErrorPage = "true"로 지정된 페이지에서만 사용 가능--%>
				<%
				if (exception != null) { // jsp 페이지에서 발생한 에러일 때
				%>
				<h3>
					jsp 페이지 오류 :
					<%=exception.getMessage()%></h3>
				<%
				} else {
				%>
				<h3
					style="text-align: center; float: left; margin-top: 30px; margin-left: 30px;">
					오류 내용 :
					<%=request.getAttribute("message")%></h3>
				<%
				}
				%>
			</div>
		</div>

		<a href="/topp/index.jsp"
			style="margin-top: 30px; display: block; text-align: center;">시작페이지로
			가기</a>

	</div>

	<footer>
		<%@ include file="../../views/common/footer.jsp"%>
	</footer>
</body>
</html>



