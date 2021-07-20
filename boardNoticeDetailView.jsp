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
</script>
<link rel="stylesheet" type="text/css" href="/topp/resources/css/board.css">
</head>

<body>
<%@ include file="../common/menubar.jsp" %>

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
	<h5>공지 게시판</h5>
	<hr><br>
	<button>수정</button> &nbsp;
	<button>삭제</button> &nbsp;
	<button onclick="writeForm();">글쓰기</button>
	
	<table  align="center" width="900" border="1" cellspacing="0" cellpadding="5">
	<tr><th><%= bnotice.getBnTitle() %></th></tr>
	<tr><td><%= bnotice.getBnWriter() %> &nbsp;&nbsp; <%= bnotice.getBnDate() %> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <%= bnotice.getBnView() %></td></tr>
	<tr><td><%= bnotice.getBnContent() %></td></tr>
	</table>
	
	<table  align="center" width="900" border="1" cellspacing="0" cellpadding="5">
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





