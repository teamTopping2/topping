<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>tbox</title>
<style type="text/css">
@import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap')
	;

@font-face {
	font-family: 'score';
	src: url(/topp/resources/fonts/SCDream4.otf);
}
t
/* 폰트 적용 */
* {
	font-family: 'Noto Sans KR', 'score', 'sans-serif';
}

#wrap {
	width: fit-content;
	min-width: 1230px;
	margin: 0 auto;
}

.wrap2 {
	width: 900px;
	margin: 0 auto;
}

.boxTitle {
	text-align: center;
	margin-top: 60px;
}

.box_contents {
	
}

.box_header {
	margin-top: 100px;
}

.box_count {
	border: solid 1px Gainsboro;
	border-radius: 5px;
	background-color: WhiteSmoke;
	margin-top: 20px;
	width: 900px;
	height: 50px;
}

.box_none {
	border: solid 1px Gainsboro;
	border-radius: 5px;
	background-color: WhiteSmoke;
	margin-top: 20px;
	width: 900px;
	height: 60px;
}

.b_count {
	margin-left: 20px;
	margin-top: 5px;
	line-height: 35px;
	color: rgb(127, 127, 127);
}

.table {
	margin-top: 50px;
}

.btn_delete {
	width: 100px;
	height: 35px;
	background-color: white;
	border-color: Gainsboro;
}

.btn_share {
	width: 100px;
	height: 35px;
	border: 0;
	background-color: DeepSkyBlue;
	color: white;
	float: right;
}
</style>
</head>
<body>
	<header>
		<%@ include file="/views/common/menubar.jsp"%>
	</header>
	<div id="wrap">
		<div class="wrap2">
			<h1 class="boxTitle">트립박스</h1>
			<div class="box_contents">
				<div class="box_header">
					<h4>
						<b>보관함</b>
					</h4>
					<div class="box_count">
						<h5 class="b_count">총 0건</h5>
						<!-- 총 개수 들어갈 곳 -->
					</div>
				</div>
			</div>
			<div class="box_main">
				<div class="box_drop"></div>
				<div>
					<table class="table table-bordered">
						<thead class="table-light">
							<tr>
								<th scope="col"><input type="checkbox"></th>
								<th scope="col">번호</th>
								<th scope="col">계획명</th>
								<th scope="col">여행경로</th>
								<th scope="col">지역</th>
							</tr>
						</thead>
						<tbody>
							<%--  <% for(Box b : blist) %> --%>
							<tr>
							</tr>
						</tbody>
					</table>
					<!--<tr>
							<th scope="row"><input type="checkbox"></th>
							<td>Jacob</td>
							<td>Thornton</td>
							<td>@fat</td>
						</tr>-->
					<h5 style="text-align: center;">보관함에 여행정보가 없습니다.</h5>
					<div class="box_none"></div>
					<div style="margin-top: 10px;">
						<button class="btn_delete" onclick="btn_selectD">선택삭제</button>
						<button class="btn_share" onclick="btn_share">공유하기</button>
					</div>
				</div>
			</div>
		</div>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
	</div>
	<footer>
		<%@ include file="../../views/common/footer.jsp"%>
	</footer>
</body>
</html>