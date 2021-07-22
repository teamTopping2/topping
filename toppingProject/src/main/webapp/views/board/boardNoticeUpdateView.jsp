<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="board.notice.model.vo.BoardNotice"%>
<%
	BoardNotice bnotice = (BoardNotice)request.getAttribute("bnotice");
	int currentPage = (Integer)request.getAttribute("page");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board</title>
<link rel="stylesheet" type="text/css" href="/topp/resources/css/board.css">
<script type="text/javascript">
function updateNotice(){
	location.href="/topp/bnupdate";
}

function bnList(){
	location.href="/topp/bnlist?page=<%= currentPage %>"
}
</script>
</head>

<body>
<%@ include file="../common/menubar.jsp" %>
<br>

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

<h4 align="center"><%= bnotice.getBnNo() %>번 게시글 수정</h4>
<br>

<form action="/topp/bnupdate" method="post" enctype="multipart/form-data">
<input type="hidden" name="bnNo" value="<%= bnotice.getBnNo() %>">
<input type="hidden" name="ofile" value="<%= bnotice.getOrgFilename() %>">
<input type="hidden" name="rfile" value="<%= bnotice.getReFilename() %>">
<input type="hidden" name="page" value="<%= currentPage %>">

<table align="center" width="900" cellspacing="0" cellpadding="5">
<tr><td>
	<select name="boardtype" id="boardtype" disabled>
		<option value="notice">공지 게시판</option>
	</select>
</td></tr>
<tr>
	<td><input type="text" name="title" size="70" value="<%= bnotice.getBnTitle() %>"></td>
</tr>
<tr>
	<td><input type="text" name="writer" readonly value="<%= bnotice.getBnWriter() %>"></td>
</tr>
<tr><td>
	<% if(bnotice.getOrgFilename() != null) { %>
		<%= bnotice.getOrgFilename() %> &nbsp;
		<input type="checkbox" name="deleteFile" value="yes">삭제<br>
		변경할 파일: <input type="file" name="upfile">
	<% } else { %>
		첨부된 파일 없음<br>
		추가할 파일: <input type="file" name="upfile">
	<% } %>
</td></tr>
<tr>
	<td><textarea rows="10" cols="100" name="content"><%= bnotice.getBnContent() %></textarea></td>
</tr>
<tr><th>
	<input type="submit" value="수정하기"> &nbsp;
	<input type="reset" value="수정 취소"> &nbsp;
	<input type="button" value="목록으로" onclick="bnList(); return false;">
</th></tr>
</table>

</form>










<%@ include file="../common/footer.jsp" %>
</body>
</html>




