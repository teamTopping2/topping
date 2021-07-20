<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, java.sql.Date, board.ques.model.vo.BoardQues" %>
<%
	ArrayList<BoardQues> list = (ArrayList<BoardQues>)request.getAttribute("list");
	int listCount = ((Integer)request.getAttribute("listCount")).intValue();
	int startPage = ((Integer)request.getAttribute("startPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board</title>
<script type="text/javascript">
function writeForm(){
	location.href="/topp/views/board/boardWriteForm.jsp"
}
</script>
<link rel="stylesheet" type="text/css" href="/topp/resources/css/board.css">
</head>

<body>
<%@ include file="../common/menubar.jsp" %>
<br><br>

<%-- 서브 메뉴바 --%>
<div class="submenu">
<section>
<ul>
	<li><h5><a href="/topp/bnlist">공지 게시판</a></h5></li>
	<li><h5><a href="/topp/bqlist">질문 게시판</a></h5></li>
	<li><h5><a href="/topp/bflist">자유 게시판</a></h5></li>
</ul>

</section>
</div>

<%-- 본문 --%>
<div class="board">
	<h5>질문 게시판</h5>
	<hr><br>
	<h6 style="text-align: center;">총 게시글 수: <%= listCount %></h6>	
	<button onclick="writeForm();">글쓰기</button>
	<br><br>

	<table align="center" border="1" cellspacing="0" cellpadding="5" width="900">
		<tr><th>글 번호</th><th>제목</th><th>작성자</th><th>작성날짜</th><th>첨부파일</th><th>조회수</th></tr>
	
		<% for (BoardQues b : list) { %>
			<tr>
				<th><%= b.getBqNo() %></th>
				<td>
					<a href="/topp/bqdetail?bqNo=<%= b.getBqNo() %>&page=<%= currentPage %>"><%= b.getBqTitle() %></a>
				</td>
				<td align="center"><%= b.getBqWriter() %></td>
				<td align="center"><%= b.getBqDate() %></td>
				<td align="center">
				<% if(b.getOrgFilename() != null) { %>
					○
				<% } else { %>
					&nbsp;
				<% } %>
				</td>
				<td align="center"><%= b.getBqView() %></td>
			</tr>
		<% } %>

	</table>
</div>

<%-- 페이징 처리 --%>
<div style="text-align:center;">
	<% if(currentPage <= 1) { %>
		[첫 페이지] &nbsp;
	<% } else { %>
		<a href="/topp/bqlist?page=1">[첫 페이지]</a> &nbsp;
	<% } %>
	
	<%-- 이전 페이지 그룹으로 이동 --%>
	<% if((currentPage - 10) < startPage && (currentPage - 10) > 1) { %>
		<a href="/topp/bqlist?page=<%= startPage - 10 %>">[이전]</a> &nbsp;
	<% } else { %>
		[이전] &nbsp;
	<% } %>
	
	<%-- 현재 페이지 숫자 출력 --%>
	<% for(int p = startPage; p <= endPage; p++) { 
		if(p == currentPage) { %>
			<font color="red" size="4">[<%= p %>]</font>
		<% } else { %>
			<a href="/topp/bqlist?page=<%= p %>"><%= p %></a>
	<% }} %> &nbsp;
	
	<%-- 다음 페이지 그룹으로 이동 --%>
	<% if((currentPage + 10) > endPage && (currentPage + 10) < maxPage) { %>
		<a href="/topp/bqlist?page=<%= endPage + 10 %>">[다음]</a> &nbsp;
	<% } else { %>
		[다음] &nbsp;
	<% } %>
	
	<% if(currentPage >= maxPage) { %>
		[마지막 페이지] &nbsp;
	<% } else { %>
		<a href="/topp/bqlist?page=<%= maxPage %>">[마지막 페이지]</a> &nbsp;
	<% } %>
	
</div>




<br><br><br><br><br>

<%@ include file="../common/footer.jsp" %>
</body>
</html>






