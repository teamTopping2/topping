<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="board.notice.model.vo.BoardNotice, board.notice.model.vo.BoardNoticeReply, java.util.ArrayList"%>
<%
BoardNotice bnotice = (BoardNotice)request.getAttribute("bnotice");
int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
ArrayList<BoardNoticeReply> list = (ArrayList<BoardNoticeReply>)request.getAttribute("list");
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

function moveUpview(){
	location.href="/topp/bnupview?bnNo=<%= bnotice.getBnNo() %>&page=<%= currentPage %>";
}

function deleteBoard(){
	location.href="/topp/bndelete?bnNo=<%= bnotice.getBnNo() %>&rfile=<%= bnotice.getReFilename() %>";
}
</script>
<link rel="stylesheet" type="text/css" href="/topp/resources/css/boardCss.css">
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
	<h3>공지 게시판</h3>
	<hr><br>
	
	<div style="width: 950px" align="right">
		<button onclick="moveUpview(); return false;">수정</button> &nbsp;
		<button onclick="deleteBoard(); return false;">삭제</button> &nbsp;
		<button onclick="writeForm(); return false;">글쓰기</button>
	</div>
	
	<table  align="center" width="900" border="1" cellspacing="0" cellpadding="5">
	<tr><th colspan="3"><%= bnotice.getBnTitle() %></th></tr>
	<tr><td colspan="4"><%= bnotice.getBnWriter() %> &nbsp;&nbsp; <%= bnotice.getBnDate() %> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <%= bnotice.getBnView() %></td></tr>
	<tr><td colspan="4"><%= bnotice.getBnContent() %></td></tr>
	<tr><td colspan="4">
		<% if(bnotice.getOrgFilename() != null) { %>
			<a href="/topp/bnfdown?ofile=<%= bnotice.getOrgFilename() %>&rfile=<%= bnotice.getReFilename() %>">
			<%= bnotice.getOrgFilename() %></a>
		<% } else { %>
			&nbsp;
		<% } %>
	</td></tr>
	
	<% for (BoardNoticeReply bnr : list) { %>
			<tr>
				<th><%= bnr.getComNo() %></th>
				<td><%= bnr.getComWriter() %></td>
				<td><%= bnr.getComContent() %></td>
				<td><%= bnr.getComDate() %></td>
			</tr>
		<% } %>
	<tr><td colspan="4">
		<button onclick="javascript:location.href='/topp/bnlist?page=<%= currentPage %>'">목록으로</button>
	</td></tr>
	</table>
	
</div>










<%@ include file="../common/footer.jsp" %>
</body>
</html>





