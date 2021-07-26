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
<script type="text/javascript"
	src="/topp/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6ef4dba9226523d458a779235b1eea67"></script>
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

.trip_list_total {
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
	border: solid 1px silver;
	border-radius: 10px;
	padding-bottom: 10px;
	white-space: normal;
	overflow: hidden;
	width: 570px;
	height: 130px;
}

.plan_contents {
	width: 1200px;
	height: 900px;
	text-align: center;
	margin-right: 0;
	margin-top: 40px;
	border: 2px solid black;
	position: relative;
}

.scrap_contents {
	width: 1100px;
	height: 250px;
	margin: 0 auto;
}

.scrap_content {
	display: inline-block;
	float: left;
	margin-top: 20px;
}

.scrap_no2 {
	width: 35px;
	height: 35px;
	float: left;
	line-height: 35px;
	margin-left: 20px;
	border: 1px solid;
	border-radius: 50%;
}

.scrap_name {
	float: left;
	margin-left: 20px;
}

.scrap_right {
	width: 35px;
	height: 35px;
	float: left;
	line-height: 35px;
	margin-left: 20px;
	margin-top: 20px;
}
</style>
<script type="text/javascript">
	var list =
<%=tlist%>
	;
	$(function() {
		if (list == null) {
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
			<h3 style="display: inline-block;">
				<b>계획명 : </b>
				<input id="input_name" onchange="change_name()"
					placeholder="계획명을 입력해주세요!" onfocus="this.placeholder=''"
					onblur="this.placeholder='  계획명을 입력해주세요!'" size="30"
					style="border: 0; width: 400px; height: 33px;" />
				<h3 id="plan_name" style="display: inline-block; margin-left: 20px;"><h3>
			</h3>
			<script>
			function change_name()  {
				  const name = document.getElementById('input_name').value;
				  document.getElementById("plan_name").innerText = name;
				  $('#input_name').hide();
				  console.log($('#plan_name').text());
				};
			</script>
		</div>
		<div class="trip_map">
			<!-- 계획명 -->
			<div class="trip_main">
				<!-- 블로그 리스트 출력 -->
				<%
				int i = 1;
				for (Trip t : tlist) {
				%>
				<ul class="trip_list_total">
					<li class="sbx">
						<div class="trip_box">
							<div class="scrap_no">
								<span class="no_color"><%=i%></span>
							</div>
							<a class="trip_thumbL" href="#" target="_blank"> <img
								class="trip_thumb" src=<%=t.getTripThumb()%>>
							</a>
							<div class="trip_conbox">
								<div class="trip_title">
									<h5 class="scrap_title">
										<%=t.getTripName()%>
									</h5>
								</div>
								<!-- 보이지 않는 곳에 좌표값 저장 -->
								<span class="scrap_la" style="display: none"><%=t.getLatitude()%></span>
								<span class="scrap_lo" style="display: none"><%=t.getLongitude()%></span>
								<div class="trip_content"><%=t.getTripContent()%></div>
							</div>
						</div>
					</li>
				</ul>
				<%
				i++;
				}
				%>
				<script type="text/javascript">
					var colors = [ "
					Red", "Orange", "Green", "Blue",
							"BlueViolet", "HotPink", "SlateGray" ];
					var
					nocolor=document.getElementsByClassName( "no_color");
					for
					(var i=j = 0; i
				< nocolor.length; i++, j++) { if (j == 7) { j = 0; } ;
				nocolor[i].style.color = colors[j]; };
				</script>
			</div>
			<!-- 지도 -->
			<div id="map"
				style="width: 600px; height: 500px; border: 1px solid grey;"></div>
			<script>
			var container = document.getElementById('map');
			var options = {
				center : new kakao.maps.LatLng($('.scrap_la').first().text(),
						$('.scrap_lo').first().text()),//첫번째 리스트 좌표
				level : 8
			};

			var map = new kakao.maps.Map(container, options);
			//마커 생성 반복문
			//타이틀 주소 따로 리스트

			var title = [];

			//title에 이름 리스트로 추가
			$('.scrap_title').each(function() {
				title.push($(this).text().replace(/\t|\n/gm, ""));
			});
			console.log(title);
			//좌표 추가 latlng: new kakao.maps.LatLng(33.450705, 126.570677)

			var mapX = [];

			var mapY = [];

			$('.scrap_la').each(function() {
				mapX.push(parseFloat($(this).text().replace(/\t|\n/gm, "")));
			});

			$('.scrap_lo').each(function() {
				mapY.push(parseFloat($(this).text().replace(/\t|\n/gm, "")));
			});

			var latlng = [];

			for (var i = 0; i < title.length; i++) {
				var pos = new kakao.maps.LatLng(mapX[i], mapY[i]);
				//console.log(pos) 확인용
				latlng.push(pos);
			};

			// 마커 이미지의 이미지 주소입니다
			var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

			for (var i = 0; i < title.length; i++) {

				// 마커 이미지의 이미지 크기 입니다
				var imageSize = new kakao.maps.Size(24, 35);

				// 마커 이미지를 생성합니다    
				var markerImage = new kakao.maps.MarkerImage(imageSrc,
						imageSize);

				// 마커를 생성합니다
				//console.log(latlng[i]); 마커 좌표 확인용
				//console.log(title[i]);  마커 이름 확인용
				var marker = new kakao.maps.Marker({
					map : map, // 마커를 표시할 지도
					position : latlng[i], // 마커를 표시할 위치
					title : title[i], // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
					image : markerImage
				// 마커 이미지 
				});
			};
		</script>
		</div>
		<!-- 계획 일정 표시 -->
		<div class="plan_contents">
			<h2 style="margin-top: 30px; margin-bottom: 30px;">계획 일정</h2>
			<!-- 리스트 순서대로 나열 -->
			<div class="scrap_contents">
				<%
				int k = 1;
				for (Trip t : tlist) {
				%>
				<div class="scrap_content">
					<div class="scrap_no2">
						<span class="no_color2" style="color: white;"><h4><%=k%></h4></span>
					</div>
					<div class="scrap_name">
						<h4><%=t.getTripName()%></h4>
					</div>
				</div>
				<div class="scrap_right">
					<h4>→</h4>
				</div>
				<%
				k++;
				}
				%>
			</div>
			<div class="">
				<h2>전체 거리</h2>
			</div>
			<script type="text/javascript">
			var colors = [ "Red", "Orange", "Green", "Blue", "BlueViolet",
					"HotPink", "SlateGray" ];
			var scrap_no2 = document.getElementsByClassName("scrap_no2");
			for (var i = j = 0; i < scrap_no2.length; i++, j++) {
				if (j == 7) {
					j = 0;
				}
				scrap_no2[i].style.color = colors[j];
				scrap_no2[i].style.backgroundColor = colors[j];
			};
			$('.scrap_right').children().last().remove(); //마지막 -> 제거

			$(function() {
				$("#btn_save").on("click", function() {
					if (confirm("트립박스에 저장하시겠습니까")) {
						history.go(-1);
					} else {
						return;
					}
				});
			});
		</script>
			<button type="button" id="btn_save" class="btn btn-primary"
				style="width: 130px; height: 45px; position: absolute; bottom: 30px; right: 44%;">저장</button>
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