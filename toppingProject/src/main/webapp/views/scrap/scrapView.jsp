<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<title>scrap</title>

<style type="text/css">
@import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap')
	;

* {
	font-family: 'Noto Sans KR', 'score', 'sans-serif';
}

#wrap {
	width: fit-content;
	min-width: 1230px;
	margin: 0 auto;
}

#map {
	float: right
}

.plan_title {
	margin-left: 50px;
	margin-bottom: 40px;
}

.trip_map {
	width: 1200px;
	height: 510px;
	clear: both;
}

.blog_main {
	overflow: auto;
	width: 600px;
	height: 500px;
	float: left;
}

.blog_main::-webkit-scrollbar {
	width: 15px;
}

.blog_main::-webkit-scrollbar-thumb {
	border-radius: 10px;
	background-color: LightCoral;
}

.blog_main::-webkit-scrollbar-track {
	border-radius: 10px;
	background-color: white;
	box-shadow: inset 0px 0px 5px white;
	border: 1px solid grey;
}

.blog_list_total {
	padding: 0;
}

.scrap_no {
	width: 35px;
	height: 98px;
	text-align: center;
	line-height: 98px;
	font-size: x-large;
	color: Black;
}

.blog_thumb {
	width: 165px;
	margin-right: 10px;
	border-bottom-left-radius: 5px;
	border-bottom-right-radius: 5px;
	border-top-left-radius: 5px;
	border-top-right-radius: 5px;
}

.blog_title {
	width: 310px;
}

.blog_box {
	margin: 0;
	display: flex;
	padding-top: 10px;
	padding-left: 15px;
	padding-bottom: 10px;
	border: solid 1px rgb(232, 235, 238);
	border-radius: 10px;
	padding-bottom: 10px;
	white-space: normal;
	overflow: hidden;
	width: 580px;
	height: 120px;
}

.plan_contents {
	width: 1200px;
	height: 800px;
	text-align: center;
	margin-right: 0;
	margin-top: 40px;
	border: 2px solid black;
	position: relative;
}
</style>

<script type="text/javascript"
	src="/topp/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
	<header>
		<%@ include file="/views/common/menubar.jsp"%>
	</header>
	<div id="wrap">

		<h1 style="text-align: center; margin-top: 60px; margin-bottom: 60px;">스크랩
			확인</h1>
		<div class="plan_title">
			<h4>
				<b>계획명 : 강릉 여행!</b>
			</h4>
		</div>
		<div class="trip_map">
			<!-- 계획명 -->
			<div class="blog_main">
				<!-- 블로그 리스트 출력 -->
				<ul class="blog_list_total">
					<li class="sbx">
						<div class="blog_box">

							<div class="scrap_no">1</div>
							<a class="blog_thumb" href="<%-- <%=s.getBlogLink()%> --%>"
								target="_blank"> <img class="blog_thumb"src=<%-- <%=s.getBlogThumb()%> --%>>
							</a>
							<div class="blog_conbox">
								<div class="blog_title">
									<h5>
										<%-- <%=s.getBlogTitle()%> --%>
									</h5>
								</div>
								<div>
									<%-- <%=s.getBlogName()%> --%>
								</div>
							</div>
						</div>
					</li>
				</ul>
			</div>
			<!-- 지도 -->
			<div id="map" style="width: 600px; height: 500px; border: 1px solid grey;"></div>
			<script type="text/javascript"
				src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6ef4dba9226523d458a779235b1eea67"></script>
			<script>
				var container = document.getElementById('map');
				var options = {
					center : new kakao.maps.LatLng(37.75182973893725,
							128.87605390660724),
					level : 8
				};

				var map = new kakao.maps.Map(container, options);
			</script>
		</div>


		<div class="plan_contents">
			<h2 style="margin-top: 20px;">계획 일정</h2>
		
			<button type="button" class="btn btn-primary"
				style="width: 130px; height: 45px; position: absolute; bottom: 30px; right: 43%;">저장</button>
		</div>
	</div>
	<footer>
		<%@ include file="../../views/common/footer.jsp"%>
	</footer>

</body>
</html>