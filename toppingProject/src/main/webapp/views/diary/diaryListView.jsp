<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, diary.model.vo.Diary, java.sql.Date" %>    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
<script type="text/javascript">
function showWriteForm(){
	location.href = "/top/views/diary/diaryWriteForm.jsp";
}
</script>
</head>
<body>

<%@ include file="../common/menubar.jsp" %>
<br>

<h1>나의 여행일기 이야기</h1>
<%
		// 메인 페이지로 이동했을 때 세션에 값이 담겨있는지 체크
		String userID = null;
		if(session.getAttribute("userID") != null){
			userID = (String)session.getAttribute("userID");
		}
	%>

		<!-- 게시판 제목 이름 옆에 나타나는 메뉴 영역 -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="main.jsp">메인</a></li>
				<li class="active"><a href="bbs.jsp">게시판</a></li>
			</ul>
			<%
				// 로그인 하지 않았을 때 보여지는 화면
				if(userID == null){
			%>
			<!-- 헤더 우측에 나타나는 드랍다운 영역 -->
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">접속하기<span class="caret"></span></a>
					<!-- 드랍다운 아이템 영역 -->	
					<ul class="dropdown-menu">
						<li><a href="login.jsp">로그인</a></li>
						<li><a href="join.jsp">회원가입</a></li>
					</ul>
				</li>
			</ul>
			<%
				// 로그인이 되어 있는 상태에서 보여주는 화면
				}else{
			%>
			<!-- 헤더 우측에 나타나는 드랍다운 영역 -->
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">회원관리<span class="caret"></span></a>
					<!-- 드랍다운 아이템 영역 -->	
					<ul class="dropdown-menu">
						<li><a href="logoutAction.jsp">로그아웃</a></li>
					</ul>
				</li>
			</ul>
			<%
				}
			%>
		</div>
	</nav>
	<!-- 네비게이션 영역 끝 -->
	
	<!-- 게시판 메인 페이지 영역 시작 -->
	<div class="container">
		<div class="row">
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color: #eeeeee; text-align: center;">여행 일기 번호</th>
						<th style="background-color: #eeeeee; text-align: center;">여행 일기 제목</th>
						<th style="background-color: #eeeeee; text-align: center;">여행 일기 쓴이</th>
						<th style="background-color: #eeeeee; text-align: center;">여행 일기 작성일자</th>
					</tr>
				</thead>
				<tbody>
					<tr href = "diaryDetailView.jsp">
						<!-- 테스트 코드 -->
						<td>1</td>
						<td>이렇게하면, 극락인가 나락인가</td>
						<td>극락을 추구하는 자</td>
						<td>2020-07-13</td>
					</tr>
					<tr>
						<!-- 테스트 코드2 -->
						<td>2</td>
						<td>이렇게하면, 성공인가 실패인가</td>
						<td>나락을 추구하는 자</td>
						<td>2020-07-20</td>
					</tr>
				</tbody>
			</table>
			<!-- 글쓰기 버튼 생성 -->
			<a href="diaryWriteForm.jsp" class="button">나의 일기 쓰기</a>
		</div>
	</div>
	<!-- 게시판 메인 페이지 영역 끝 -->
	
	<!-- 부트스트랩 참조 영역 -->
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
	
<%@ include file="../common/footer.jsp" %>
<br>
</body>
</html>



