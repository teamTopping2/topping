<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board</title>
<link rel="stylesheet" type="text/css" href="/topp/resources/css/board.css">
<script type="text/javascript">
function writeBoard() {
	var boardtype = document.getElementById("boardtype").value;

	if (boardtype == "notice") {
		document.getElementById("boardinsert").setAttribute('action', '/topp/bninsert');
	}

	if (boardtype == "ques") {
		document.getElementById("boardinsert").setAttribute('action', '/topp/bqinsert');
	}

	if (boardtype == "free") {
		document.getElementById("boardinsert").setAttribute('action', '/topp/bfinsert');
	}
	
} // writeBoard

function chooseType() {
	var boardtype = document.getElementById("boardtype").value;

	if (boardtype != "notice") {
		document.getElementById("type").disabled = false;
	}
	
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

<h4 align="center">게시글 등록</h4>
<br>

<form method="post" enctype="multipart/form-data" id="boardinsert">
<table align="center" width="900" cellspacing="0" cellpadding="5">
<tr><td>
	<select name="boardtype" id="boardtype" onchange=" return chooseType();">
		<option value="notice">공지 게시판</option>
		<option value="ques">질문 게시판</option>
		<option value="free">자유 게시판</option>
	</select> &nbsp;
	
	<select name="type" id="type" disabled>
		<option value="food">맛집</option>
		<option value="hotel">숙소</option>
		<option value="transport">교통</option>
		<option value="accompany">동행</option>
		<option value="etc" selected>기타</option>
	</select>
</td></tr>
<tr>
	<td><input type="text" name="title" size="70" placeholder="제목을 입력하세요."></td>
</tr>
<tr>
	<td><input type="text" name="writer"  readonly placeholder="작성자 닉네임"></td>
</tr>
<tr>
	<td><input type="file" name="upfile"></td>
</tr>
<tr>
	<td><textarea rows="10" cols="100" name="content" placeholder="내용을 입력하세요"></textarea></td>
</tr>
<tr><th>
	<input type="submit" value="등록하기" onclick="return writeBoard();"> &nbsp;
	<input type="reset" value="작성취소"> &nbsp;
	<input type="button" value="뒤로가기" onclick="javascript:history.go(-1); return false;">
</th></tr>
</table>

</form>





<%@ include file="../common/footer.jsp" %>
</body>
</html>






