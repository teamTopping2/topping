<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>trip</title>
</head>
<body>
<%@ include file="../common/menubar.jsp" %>
<hr>
<h1 align="center">나의 여행 일기 작성하기</h1>
<br>

<!-- form 에서 입력값들과 파일을 함께 전송하려면
반드시 속성을 추가해야 함 : enctype="multipart/form-data" -->
<div class="container">
		<div class="row">
			<form method="post" action="diaryDetailView.jsp">
				<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2" style="background-color: #eeeeee; text-align: center;">일기 글쓰기 양식</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="text" class="form-control" placeholder="글 제목" name="dirtitle" maxlength="50"></td>
						</tr>
						<tr>
							<td><textarea class="form-control" placeholder="글 내용" name="dircontent" maxlength="2048" style="height: 350px;"></textarea></td>
						</tr>
					</tbody>
				</table>
</div>			
<tr><th colspan="2">
	<input type="submit" value="나의 일기 등록하기"> &nbsp; 
	<input type="reset" value="나의 일기 작성취소"> &nbsp;
	<input type="button" value="일기 목록" onclick="javascript:location.href='/top/dlist?page=1'; return false;">
</th></tr>
</div>
<br>

<hr>
<%@ include file="../common/footer.jsp" %>
</body>
</html>



