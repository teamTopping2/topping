<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<title>topp</title>

<style type="text/css">

/* 폰트 경로 */
@import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap')
	;

@font-face {
	font-family: 'neon';
	src: url('../srcs/fonts/NeonPlanetDisplay.ttf') format('truetype');
}

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

.search_header {
	text-align: center;
	margin-bottom: 50px;
}

.searchBar {
	display: inline-block;
	margin-top: 250px;
	border-radius: 5px;
}

input:focus {
	outline: none;
}

.btn_search_submit {
	color: white;
	background-color: LightCoral;
	border: 0;
}

.bimage {
	height: 570px;
	background-image: url("/topp/resources/images/home.jpg");
	background-size: 1230px;
	border-bottom: 2px solid grey;
	margin-bottom: 100px;
}

.best_diary {
	margin-bottom: 200px;
}

.best_board {
	margin-bottom: 200px;
}

.htip {
	margin-bottom: 200px;
}
</style>
</head>
<body>
	<header>
		<%@ include file="views/common/menubar.jsp"%>
	</header>
	<div id="wrap">
		<div class="bimage">
			<div class="search_header">
				<!-- 여행정보 검색 -->
				<form action="/topp/tlist" method="post" name="fr"
					onsubmit="return check()">
					<!-- 여행 검색바 -->
					<div class="searchBar">
						<div class="input-group mb-3">
							<input type="text" class="form-control"
								placeholder="   여행가고 싶은 곳을 입력해주세요."
								aria-label="Recipient's username"
								aria-describedby="basic-addon2" onfocus="this.placeholder=''"
								onblur="this.placeholder='   여행가고 싶은 곳을 입력해주세요.'" size="50"
								style="border: 0; width: 500px; height: 40px;">
							<div class="input-group-append">
								<button class="btn btn-outline-secondary" type="button"
									style="border: 1px solid white; color: white; background-color: SkyBlue;">검색</button>
							</div>
						</div>

					</div>
					<h6
						style="width: 500px; text-align: left; margin: 0 auto; margin-bottom: 30px; color: white;">
						<b>#강릉 &nbsp; #제주 &nbsp; #여수</b>
					</h6>
			</div>
		</div>
		<div>
			<!-- BEST 여행일기 -->
			<div class="best_diary">
				<h1>
					<b>BEST 여행일기 &nbsp;<i class="bi bi-camera"
						style="font-size: 3rem; color: DeepSkyBlue"></i></b>
				</h1>
			</div>
			<!-- BEST 게시글 -->
			<div class="best_board">
				<h1>
					<b>BEST 게시글 &nbsp;<i class="bi bi-hand-thumbs-up"
						style="font-size: 3rem; color: DeepSkyBlue"></i></b>
				</h1>
			</div>
			<!-- 여행가기전 꿀팁 -->
			<div class="htip">
				<h1>
					<b>여행가기 전 체크할 꿀팁! &nbsp;<i class="bi bi-check2"
						style="font-size: 3rem; color: DeepSkyBlue"></i></b>
				</h1>
			</div>
		</div>
	</div>
	<footer>
		<%@ include file="views/common/footer.jsp"%>
	</footer>
</body>
</html>