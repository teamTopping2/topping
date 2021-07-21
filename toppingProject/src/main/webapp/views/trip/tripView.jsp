<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, trip.model.vo.Trip"%>
<%
ArrayList<Trip> tlist = (ArrayList<Trip>) request.getAttribute("tlist");
ArrayList<Trip> slist = (ArrayList<Trip>) request.getAttribute("slist");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<title>trip</title>

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
	margin-top: 60px;
	margin-bottom: 50px;
}

.searchBar {
	display: inline-block;
	margin-top: 40px;
	margin-bottom: 20px;
	border: 1px solid LightCoral;
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

label {
	display: inline-block;
	width: 80px;
	line-height: 25px;
}

.searchView {
	display: inline-block;
	width: 1230px;
	margin-right: 80px;
	margin-top: 40px;
}

.bx {
	list-style: none;
}

.searchbTitle {
	margin-left: 50px;
	float: left;
	width: 580px;
}

.searchtTitle {
	margin-left: 30px;
	width: 500px;
	float: left;
}

.blog_main {
	overflow: auto;
	margin-left: 50px;
	width: 580px;
	height: 800px;
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

.trip_list_total {
	padding: 0;
}

.trip_main {
	overflow: auto;
	margin-left: 30px;
	width: 500px;
	height: 800px;
	float: left;
	border-left: solid 2px PapayaWhip;
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

.blog_thumb {
	width: 165px;
	margin-right: 10px;
	border-bottom-left-radius: 5px;
	border-bottom-right-radius: 5px;
	border-top-left-radius: 5px;
	border-top-right-radius: 5px;
}

.trip_thumb {
	width: 165px;
	margin-right: 10px;
	border-bottom-left-radius: 5px;
	border-bottom-right-radius: 5px;
	border-top-left-radius: 5px;
	border-top-right-radius: 5px;
}

.blog_box {
	margin-left: 30px;
	margin-right: 10px;
	display: flex;
	padding-top: 10px;
	padding-left: 15px;
	padding-bottom: 10px;
	border: solid 1px rgb(232, 235, 238);
	border-radius: 10px;
	padding-bottom: 10px;
	white-space: normal;
	overflow: hidden;
	height: 145px;
}

.trip_box {
	margin-left: 30px;
	margin-right: 10px;
	display: flex;
	padding-top: 15px;
	padding-left: 15px;
	padding-bottom: 20px;
	padding-right: 15px;
	border: solid 1px rgb(232, 235, 238);
	border-radius: 10px;
	white-space: normal;
	overflow: hidden;
	height: 145px;
	border: solid 1px rgb(232, 235, 238);
	display: flex;
	padding-top: 15px;
}

#quick_menu2 {
	position: absolute;
	left: 0;
	right: 0;
	top: 268px;
	z-index: 9999;
	min-width: 1010px;
	height: 0;
	background-color: transparent;
}

#quick_menu2 .quick_label {
	font-size: 0;
	color: transparent;
	position: absolute;
	visibility: hidden;
}

#quick_menu2 .quick_contents {
	position: absolute;
	top: 50px;
	right: 40px;
	/* left: 50%;
	margin-left: 500px; */
	width: 63px;
}

#quick_menu2 .btn_quick_top {
	margin-bottom: 2px;
}

#quick_menu2 .btn_quick_top a {
	display: block;
	height: 34px;
	font-size: 0;
	color: transparent;
	border: 1px solid #d2d2d2;
	background: #f9f9f9
		url('http://image.kyobobook.co.kr/ink/images/gnb/nav6_btn_sprite.png')
		no-repeat 22px -108px;
	transition: all 0.2s;
}

#quick_menu2 .btn_quick_top a:hover {
	border-color: #999;
}

#quick_menu2.fixed {
	position: fixed;
	top: auto !important;
	bottom: 320px;
	transition: all 0.2s;
}

#quick_menu2.fixed .quick_contents {
	top: auto;
	bottom: 0;
}

</style>

<script type="text/javascript">
	
	// 선택된 목록 가져오기
	function getCheckboxValue() {
		//체크 안된거 처리
		const nquery ='input[name="tripCate"]:not(:checked)';
		const nselectedEls = document.querySelectorAll(nquery);
		
		var nresult = [];
		nselectedEls.forEach((el) => {
			nresult.push(el.value);
			$('.'+el.value).hide();
		});

		//체크 된거 처리
		const query ='input[name="tripCate"]:checked';
		const selectedEls = document.querySelectorAll(query);
		
		var result = [];
			selectedEls.forEach((el) => {
			result.push(el.value);
			$('.'+el.value).show();
		});
		
	}
	
	//공백 방지
	function check() {

		if (fr.searchTrip.value == "") {

			alert("여행지를 입력해주세요!");

			fr.searchTrip.focus();

			return false;

		} else
			return true;
	}
	
	(function($){

		// Top/Down 버튼
		$('#quick_menu2 .btn_quick_top').click(function(e){
			e.preventDefault();
			$('body, html').animate({ scrollTop: 0 }, 200);
		});
		$('#quick_menu2 .btn_quick_down').click(function(e){
			e.preventDefault();
			$('body, html').animate({ scrollTop: $(document).height() - $(window).height() }, 200);
		});

	})(jQuery);
</script>

</head>
<body>
	<header>
		<%@ include file="/views/common/menubar.jsp"%>
	</header>
	<div id="wrap">
		<div class="search_header">
			<!-- 여행정보 검색 -->
			<h1 class="searchTitle">여행정보 검색</h1>
			<form action="/topp/tlist" method="post" name="fr"
				onsubmit="return check()">
				<!-- 여행 검색바 -->
				<div class="searchBar">
					<input id="searchText" type="text" name="searchTrip"
						placeholder="   여행가고 싶은 곳을 입력해주세요." onfocus="this.placeholder=''"
						onblur="this.placeholder='   여행가고 싶은 곳을 입력해주세요.'" size="50"
						style="border: 0;">
					<button class="btn_search_submit" type="submit" onclick="search">
						<i class="bi bi-search" style="font-size: 1.5rem"></i>
					</button>
				</div>
				<!-- 카테고리 체크박스 -->
				<div class="searchChk">
					<h5 style="display: inline-block; margin-right: 10px;">상세검색</h5>
					<label><input type="checkbox" name="tripCate"
							value="cate_01" checked="checked" onclick="getCheckboxValue()">관광지</label>
					<label><input type="checkbox" name="tripCate"
							value="cate_02" checked="checked" onclick="getCheckboxValue()">맛집</label>
					<label><input type="checkbox" name="tripCate"
							value="cate_03" checked="checked" onclick="getCheckboxValue()">액티비티</label>
					<label><input type="checkbox" name="tripCate"
							value="cate_04" checked="checked" onclick="getCheckboxValue()">숙박</label>
				</div>
			</form>
		</div>
		<%
		if (tlist != null) {
		%>
		<div class="searchView">
			<!-- searchTitle -->
			<div class="searchbTitle">
				<h4 style="text-align: center; margin-bottom: 35px;">
					<b>SNS 검색목록</b>
				</h4>
			</div>
			<div class="searchtTitle">
				<h4 style="text-align: center; margin-bottom: 35px;">
					<b>관광지 검색목록</b>
				</h4>
			</div>
			<!-- SNS 검색목록 -->
			<div class="blog_main">
				<h6 style="text-align: center;"></h6>
				<!-- 부제목 -->
				<%
				for (Trip s : slist) {
				%>
				<ul class="blog_list_total">
					<li class="bx" id="blog_1">
						<div class="blog_box">
							<a class="blog_thumb" href="<%=s.getBlogLink()%>" target="_blank">
								<img class="blog_thumb" src=<%=s.getBlogThumb()%>>
							</a>
							<div class="blog_conbox">
								<div>
									<h5>
										<%=s.getBlogTitle()%></h5>
								</div>
								<div>
									<%=s.getBlogName()%></div>
							</div>
						</div>
					</li>
				</ul>
				<%
				}
				%>
			</div>
			<!-- 관광지 상세정보 목록 -->
			<div class="trip_main">
				<div class="trip_contents">
					<h6 style="text-align: center;"></h6>
					<!-- 부제목 -->
					<%
					for (Trip t : tlist) {
					%>
					<ul class="trip_list_total">
						<li class="bx">
							<div class="trip_box cate_<%=t.getTripNo().substring(5, 7)%>">
								<a class="trip_thumb" href="#" target="_blank"> <img
									class="trip_thumb" src=<%=t.getTripThumb()%>>
								</a>
								<div class="trip_conbox">
									<div>
										<h5><%=t.getTripName()%></h5>
									</div>
									<div><%=t.getTripContent()%></div>
								</div>
							</div>
						</li>
					</ul>
					<%
					}
					%>
				</div>
			</div>
		</div>
		<div id="quick_menu2" class="fixed">
			<div class="quick_label">바로가기</div>
			<div class="quick_contents">

				<div class="btn_quick_top">
					<a href="#Top">TOP</a>
				</div>

			</div>
			<!-- .quick_contents -->
		</div>
		<!-- #quick_menu2 -->
		<%
		} else {
		%>
		<h2
			style="text-align: center; margin-top: 200px; color: LightSeaGreen;">여행정보를
			검색해주세요!</h2>
		<%
		}
		%>
		<br>
		<br>
		<br>

	</div>
	<footer>
		<%@ include file="../../views/common/footer.jsp"%>
	</footer>
</body>
</html>