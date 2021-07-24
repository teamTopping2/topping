<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="diary.model.vo.Diary" %>
<%
	Diary diary = (Diary)request.getAttribute("diary");
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
<script type="text/javascript">
function moveUpdateView(){
	location.href = "/top/dupview?dnum=<%= diary.getDiaryNum() %>&page=<%= currentPage %>";
}

function requestDelete(){
	location.href = "/top/ddelete?dnum=<%= diary.getDiaryNum() %>&level=<%= diary.getDiaryLevel() %>&rfile=<%= diary.getDiaryRenameFilename() %>";
}

function requestReply(){
	location.href = "/top/views/diary/diaryReplyForm.jsp?dnum=<%= diary.getDiaryNum() %>&page=<%= currentPage %>";
}
</script>
</head>
<body>
<%@ include file="../common/menubar.jsp" %>
<hr>
<h1 align="center"><%= diary.getDiaryNum() %>번 게시글 상세보기</h1>
<br>
<table align="center" width="500" border="1" cellspacing="0" 
cellpadding="5">
<tr><th width="120">제 목</th>
<td><%= diary.getDiaryTitle() %></td></tr>
<tr><th>작성자</th><td><%= diary.getUserNo() %></td></tr>
<tr><th>등록날짜</th><td><%= diary.getDiaryDate() %></td></tr>
<tr><th>첨부파일</th>
<td>
	<% if(diary.getDiaryOriginalFilename() != null){ %>
		<a href="/top/dfdown?ofile=<%= diary.getDiaryOriginalFilename() %>&rfile=<%= diary.getDiaryRenameFilename() %>">
		<%= diary.getDiaryOriginalFilename() %></a>
	
	<% }else{ %>
		&nbsp;
	<% } %>
</td></tr>
<tr><th>내 용</th><td><%= diary.getDiaryContent() %></td></tr>
<tr><th colspan="2">
	<%-- 댓글달기 버튼은 로그인한 경우에만 보이게 함 
	<% if(loginMember != null){ 
			if(loginMember.getUserId().equals(diary.getUser_No())){%>
		<button onclick="moveUpdateView(); return false;">수정페이지로 이동</button> &nbsp;
		<button onclick="requestDelete(); return false;">글삭제</button>  &nbsp;
		<%-- }else if(loginMember.getAdmin().equals("Y")){ 
			<button onclick="requestDelete(); return false;">글삭제</button> &nbsp;
			<button onclick="requestReply(); return false;">댓글달기</button> &nbsp;
		<% }else{ //로그인했는데 본인글이 아닐 때 %>
			<button onclick="requestReply(); return false;">댓글달기</button>
	<% }} %> &nbsp;
	<button onclick="javascript:location.href='/top/dlist?page=<%= currentPage %>';">목록</button> --%>
</th></tr>
</table>

<hr>
<%@ include file="../common/footer.jsp" %>
</body>
</html>