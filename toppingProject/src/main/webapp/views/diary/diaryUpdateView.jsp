<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="diary.model.vo.Diary" %>
<%
	Diary diary = (Diary)request.getAttribute("diary");
	int currentPage = ((Integer)request.getAttribute("page")).intValue();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
</head>
<body>
<%@ include file="../common/menubar.jsp" %>
<hr>
<h1 align="center"><%= diary.getDiaryNum() %>번 게시글 수정 페이지</h1>
<br>
<%-- 원글 수정 폼 : 첨부파일 수정 기능 포함 --%>
<% if(diary.getDiaryLevel() == 1){ //원글이면 %>
<!-- form 에서 입력값들과 파일을 함께 전송하려면
반드시 속성을 추가해야 함 : enctype="multipart/form-data" -->
<form action="/top/doriginupdate" method="post" 
	enctype="multipart/form-data">

<input type="hidden" name="dnum" value="<%= diary.getDiaryNum() %>">	
<input type="hidden" name="ofile" value="<%= diary.getDiaryOriginalFilename() %>">
<input type="hidden" name="rfile" value="<%= diary.getDiaryRenameFilename() %>">
<input type="hidden" name="page" value="<%= currentPage %>">

<table align="center" width="500" border="1" cellspacing="0" cellpadding="5">
<tr><th>제 목</th>
<td><input type="text" name="title" size="50" 
	value="<%= diary.getDiaryTitle() %>"></td></tr>
<tr><th>작성자</th>
	<td><input type="text" name="writer" readonly 
		value="<%= diary.getUserNo() %>"></td></tr>
<tr>
	<th>첨부파일</th>
	<td>
		<% if(diary.getDiaryOriginalFilename() != null){ %>
			<%= diary.getDiaryOriginalFilename() %> &nbsp; 
			<input type="checkbox" name="deleteFlag" value="yes"> 
			파일삭제 <br>
			변경 : <input type="file" name="upfile">
		<% }else{ %>
			첨부된 파일 없음 <br>
			추가 : <input type="file" name="upfile">			
		<% } %>
		
	</td>
</tr>
<tr><th>내 용</th>
	<td><textarea rows="5" cols="50" name="content"><%= diary.getDiaryContent() %></textarea></td></tr>
<tr><th colspan="2">
	<input type="submit" value="수정하기"> &nbsp; 
	<input type="reset" value="수정취소"> &nbsp;
	<input type="button" value="이전페이지로 이동" 
		onclick="javascript:history.go(-1); return false;"> &nbsp;
	<input type="button" value="목록" 
		onclick="javascript:location.href='/top/dlist?page=<%= currentPage %>'; return false;">
</th></tr>
</table>
</form>
<% }else{ //댓글과 대댓글 수정 폼 %>
<form action="/top/dreplyupdate" method="post">

<input type="hidden" name="dnum" value="<%= diary.getDiaryNum() %>">	
<input type="hidden" name="page" value="<%= currentPage %>">

<table align="center" width="500" border="1" cellspacing="0" cellpadding="5">
<tr><th>제 목</th>
<td><input type="text" name="title" size="50" 
	value="<%= diary.getDiaryTitle() %>"></td></tr>
<tr><th>작성자</th>
	<td><input type="text" name="writer" readonly 
		value="<%= diary.getUserNo() %>"></td></tr>
<tr><th>내 용</th>
	<td><textarea rows="5" cols="50" name="content"><%= diary.getDiaryContent() %></textarea></td></tr>
<tr><th colspan="2">
	<input type="submit" value="수정하기"> &nbsp; 
	<input type="reset" value="수정취소"> &nbsp;
	<input type="button" value="이전페이지로 이동" 
		onclick="javascript:history.go(-1); return false;"> &nbsp;
	<input type="button" value="목록" 
		onclick="javascript:location.href='/top/dlist?page=<%= currentPage %>'; return false;">
</th></tr>
</table>
</form>
<% } %>
<br>

<hr>
<%@ include file="../common/footer.jsp" %>
</body>
</html>