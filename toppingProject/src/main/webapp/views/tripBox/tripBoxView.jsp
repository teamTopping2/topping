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
	margin-left: 70px;
}

.box_header {
	margin-top: 100px;
}

.box_count {
	border: solid 1px Gainsboro;
	border-radius: 5px;
	background-color: WhiteSmoke;
	margin-top: 20px;
	width: 800px;
	height: 50px;
}

.b_count {
	margin-left: 20px;
	margin-top: 5px;
	line-height: 35px;
	color: rgb(127, 127, 127);
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