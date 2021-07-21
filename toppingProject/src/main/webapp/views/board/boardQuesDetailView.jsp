<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="board.ques.model.vo.BoardQues, board.ques.model.vo.BoardQuesReply, java.util.ArrayList"%>
<%
BoardQues bques = (BoardQues)request.getAttribute("bques");
int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
ArrayList<BoardQuesReply> list = (ArrayList<BoardQuesReply>)request.getAttribute("list");
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
	<h5>질문 게시판</h5>
	<hr><br>
	<button>수정</button> &nbsp;
	<button>삭제</button> &nbsp;
	<button onclick="writeForm();">글쓰기</button>
	
	<table  align="center" width="900" border="1" cellspacing="0" cellpadding="5">
	<tr><th colspan="4"><%= bques.getBqTitle() %></th></tr>
	<tr><td colspan="4"><%= bques.getBqWriter() %> &nbsp; <%= bques.getBqDate() %> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <%= bques.getBqView() %></td></tr>
	<tr><td colspan="4"><%= bques.getBqContent() %></td></tr>
	<tr><td colspan="4">
		<% if(bques.getOrgFilename() != null) { %>
			<a href="/topp/bqfdown?ofile=<%= bques.getOrgFilename() %>&rfile=<%= bques.getReFilename() %>">
			<%= bques.getOrgFilename() %></a>
		<% } else { %>
			&nbsp;
		<% } %>
	</td></tr>
	<tr><td colspan="4">
		<button>좋아요</button> &nbsp;
		<button>신고</button> &nbsp;
		<button onclick="javascript:location.href='/topp/bqlist?page=<%= currentPage %>'">목록으로</button>
	</td></tr>
	
	<% for (BoardQuesReply bqr : list) { %>
			<tr>
				<td><%= bqr.getComNo() %></td>
				<td><%= bqr.getComWriter() %></td>
				<td><%= bqr.getComContent() %></td>
				<td><%= bqr.getComDate() %></td>
			</tr>
	<% } %>
	</table>
	
</div>










<%@ include file="../common/footer.jsp" %>
</body>
</html>





