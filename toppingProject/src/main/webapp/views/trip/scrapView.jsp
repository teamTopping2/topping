<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, trip.model.vo.Trip"%>
<%
ArrayList<Trip> tlist = (ArrayList<Trip>) request.getAttribute("tlist");
//System.out.println(tlist); //확인용
%>

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

.trip_main {
	overflow: auto;
	width: 590px;
	height: 500px;
	float: left;
}

.trip_main::-webkit-scrollbar {
	width: 15px;
}

.trip_main::-webkit-scrollbar-thumb {
	border-radius: 10px;
	background-color: LightCoral;
}

.trip_main::-webkit-scrollbar-track {
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

.trip_content {
	width: 300px;
	height: 80px;
	line-height: 26px;
	overflow: hidden;
}

.trip_thumb {
	width: 165px;
	height: 109.77px;
	margin-left: 10px;
	margin-right: 10px;
	border-bottom-left-radius: 5px;
	border-bottom-right-radius: 5px;
	border-top-left-radius: 5px;
	border-top-right-radius: 5px;
}

.trip_title {
	width: 310px;
}

.trip_box {
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
	width: 570px;
	height: 130px;
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
	var list =
<%=tlist%>
	$(function() {
		if (list == null) {
			/* $("#btn_scrapchk").on("click", function() {  */
			//alert("리스트 없음")
			const url = new URL(location.href);
			//alert(url);
			const urlParams = url.searchParams;
			//alert(urlParams);
			const scstr = urlParams.get("scList");
			//alert(typeof (scstr)); 확인용 alter

			var form = document.createElement("form");

			form.setAttribute("charset", "UTF-8");

			form.setAttribute("method", "Post"); //Post 방식

			form.setAttribute("action", "/topp/ttoscrap"); //요청 보낼 주소

			var hiddenField = document.createElement("input");

			hiddenField.setAttribute("type", "hidden");

			hiddenField.setAttribute("name", "scstr");

			hiddenField.setAttribute("value", scstr);

			form.appendChild(hiddenField);
			document.body.appendChild(form);

			form.submit();
		} else {
			alert("오류");
		}
	});
</script>
</head>
<body>

	<header>
		<%@ include file="/views/common/menubar.jsp"%>
	</header>
	<div id="wrap">
		<h1 style="text-align: center; margin-top: 60px; margin-bottom: 60px;">스크랩확인</h1>
		<%
		if (tlist == null) {
		%>
		<!-- 로딩화면 -->
		<%
		} else {
		%>
		<div class="plan_title">
			<h4>
				<b>계획명 : 강릉 여행!</b>
			</h4>
		</div>
		<div class="trip_map">
			<!-- 계획명 -->
			<div class="trip_main">
				<!-- 블로그 리스트 출력 -->
				<%
				int i = 1;
				for (Trip t : tlist) {
				%>
				<ul class="blog_list_total">
					<li class="sbx">
						<div class="trip_box">
							<div class="scrap_no"><%= i %></div>
							<a class="trip_thumbL" href="#" target="_blank"> <img
								class="trip_thumb" src=<%=t.getTripThumb()%>>
							</a>
							<div class="trip_conbox">
								<div class="trip_title">
									<h5>
										<%=t.getTripName()%>
									</h5>
								</div>
								<div class="trip_content"><%=t.getTripContent()%></div>
							</div>
						</div>
					</li>
				</ul>
				<%
				i++;
				}
				%>
			</div>
			<!-- 지도 -->
			<div id="map"
				style="width: 600px; height: 500px; border: 1px solid grey;"></div>
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
		<%
		}
		%>
	</div>
	<footer>
		<%@ include file="../../views/common/footer.jsp"%>
	</footer>

</body>
</html>