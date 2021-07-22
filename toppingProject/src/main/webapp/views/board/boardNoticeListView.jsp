<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, java.sql.Date, board.notice.model.vo.BoardNotice" %>
<%
	ArrayList<BoardNotice> list = (ArrayList<BoardNotice>)request.getAttribute("list");
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
<link rel="stylesheet" type="text/css" href="/topp/resources/css/boardCss.css">
<script type="text/javascript">
function writeForm(){
	location.href="/topp/views/board/boardWriteForm.jsp"
}

function returnList(){
	location.href="/topp/bnlist?page=1"
}
</script>
</head>

<body>
<%@ include file="../common/menubar.jsp" %>
<br><br>

<%-- 서브 메뉴바 --%>
<div class="submenu">
<ul>
	<li><h4 align="center">커뮤니티</h4></li>
	<hr>
	<li><h5><a href="/topp/bnlist">공지 게시판</a></h5></li>
	<li><h5><a href="/topp/bqlist">질문 게시판</a></h5></li>
	<li><h5><a href="/topp/bflist">자유 게시판</a></h5></li>
</ul>

</div>

<%-- 본문 --%>
<div class="board">
	<h3>공지 게시판</h3><br>
	<h6>총 게시글 수: <%= listCount %></h6>
	
	<!-- 검색 -->
	<div class="sform" align="center">
	<form action="/topp/bnsearch" method="post">
		<select name="search">
			<option value="title">제목</option>
			<option value="writer">작성자</option>
			<option value="content">내용</option>
		</select>
		<input type="search" name="keyword">
		<input type="submit" value="검색">
		<input type="reset" value="취소" onclick="return returnList();"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" value="글쓰기" onclick=" return writeForm();">
	</form><br>
	</div>
	
	<!-- 게시글 목록 -->
	<table align="center" border="1" cellspacing="0" cellpadding="5" width="900">
		<tr><th>글 번호</th><th>제목</th><th>작성자</th><th>작성날짜</th><th>첨부파일</th><th>조회수</th></tr>
	
		<% for (BoardNotice b : list) { %>
			<tr>
				<th><%= b.getBnNo() %></th>
				<td>
					<a href="/topp/bndetail?bnNo=<%= b.getBnNo() %>&page=<%= currentPage %>"><%= b.getBnTitle() %></a>
				</td>
				<td align="center"><%= b.getBnWriter() %></td>
				<td align="center"><%= b.getBnDate() %></td>
				<td align="center">
				<% if(b.getOrgFilename() != null) { %>
					○
				<% } else { %>
					&nbsp;
				<% } %>
				</td>
				<td align="center"><%= b.getBnView() %></td>
			</tr>
		<% } %>

	</table>

	<%-- 페이징 처리 --%>
	<div align="center">
		<% if(currentPage <= 1) { %>
			[첫 페이지] &nbsp;
		<% } else { %>
			<a href="/topp/bnlist?page=1">[첫 페이지]</a> &nbsp;
		<% } %>
		
		<%-- 이전 페이지 그룹으로 이동 --%>
		<% if((currentPage - 10) < startPage && (currentPage - 10) > 1) { %>
			<a href="/topp/bnlist?page=<%= startPage - 10 %>">[이전]</a> &nbsp;
		<% } else { %>
			[이전] &nbsp;
		<% } %>
		
		<%-- 현재 페이지 숫자 출력 --%>
		<% for(int p = startPage; p <= endPage; p++) { 
			if(p == currentPage) { %>
				<font color="red" size="4">[<%= p %>]</font>
			<% } else { %>
				<a href="/topp/bnlist?page=<%= p %>"><%= p %></a>
		<% }} %> &nbsp;
		
		<%-- 다음 페이지 그룹으로 이동 --%>
		<% if((currentPage + 10) > endPage && (currentPage + 10) < maxPage) { %>
			<a href="/topp/bnlist?page=<%= endPage + 10 %>">[다음]</a> &nbsp;
		<% } else { %>
			[다음] &nbsp;
		<% } %>
		
		<% if(currentPage >= maxPage) { %>
			[마지막 페이지] &nbsp;
		<% } else { %>
			<a href="/topp/bnlist?page=<%= maxPage %>">[마지막 페이지]</a> &nbsp;
		<% } %>
	</div>
	
</div>





<%@ include file="../common/footer.jsp" %>
</body>
</html>






