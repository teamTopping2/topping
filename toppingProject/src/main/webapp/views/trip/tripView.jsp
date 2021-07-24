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
<link href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"
	rel="stylesheet" type="text/css" />

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
	margin-bottom: 5px;
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

input[type=checkbox] {
	margin-right: 7px;
}

label {
	display: inline-block;
	width: 80px;
	margin-left: 5px;
	line-height: 25px;
}

.searchView {
	display: inline-block;
	width: 1300px;
	margin-right: 60px;
	margin-top: 40px;
	padding: 20px;
	border-color: LightGrey;
	border-style: double;
}

.bbx {
	list-style: none;
	width: 580px;
}

.tbx {
	list-style: none;
	width: 590px;
}

.searchbTitle {
	float: left;
	width: 580px;
}

.searchtTitle {
	margin-left: 100px;
	width: 500px;
	float: left;
}

.blog_main {
	overflow: auto;
	width: 600px;
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

.blog_list_total {
	padding: 0;
}

.trip_list_total {
	padding: 0;
}

.trip_main {
	overflow: auto;
	margin-left: 30px;
	width: 610px;
	height: 800px;
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
	height: 110px;
	margin-right: 10px;
	border-bottom-left-radius: 5px;
	border-bottom-right-radius: 5px;
	border-top-left-radius: 5px;
	border-top-right-radius: 5px;
	margin-right: 10px;
}

.blog_title {
	width: 310px;
}

.trip_title {
	width: 300px;
}

.trip_content {
	width: 300px;
	height: 80px;
	line-height: 26px;
	overflow: hidden;
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

.btn_scrap {
	background-color: white;
	height: 24px;
	border: 0;
}

.btn_scrap:hover {
	color: red;
	transition: all 0.4s;
}

#quick_menu2 {
	position: absolute;
	left: 0;
	right: 0;
	top: 268px;
	z-index: 9999;
	min-width: 1420px;
	height: 0;
	background-color: transparent;
}

#quick_menu2 .quick_contents {
	position: absolute;
	top: 50px;
	right: 20px;
	width: 63px;
}

#quick_menu2 .btn_quick_top {
	margin-bottom: 2px;
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

.bi-pin-angle-fill {
	color: red;
}

#scrap_check{
	background-color: white;
	border: 0;
}
</style>

<script type="text/javascript"
	src="/topp/resources/js/jquery-3.6.0.min.js"></script>
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
	
	//검색어 공백, 한글 유효성 검사
	function check() {
		var check_kor = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
		var check_eng = /[a-zA-Z]/;
		var check_num = /[0-9]/;
		var check_spc = /[~!@#$%^&*()_+|<>?:{}]/;
		
		if (fr.searchTrip.value == "" ) {

			alert("여행지를 입력해주세요!");

			fr.searchTrip.focus();

			return false;

		} 
		
		if( check_kor.test(fr.searchTrip.value) && !check_num.test(fr.searchTrip.value) && !check_eng.test(fr.searchTrip.value) && !check_spc.test(fr.searchTrip.value) ) { 
			
			return true; 
		
		} else { 
			
			alert("한글만 입력 가능합니다."); 
			
			fr.searchTrip.value = "";
			
			fr.searchTrip.focus();
			
			return false; 
		}
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
    //<i class="bi bi-pin-angle-fill"></i>
	var scList = [];
	var scstr = "";
    $(function() {
    	var scrap = $('.btn_scrap');
    	scrap.click(function() {
			$(this).children().toggleClass('bi-pin-angle bi-pin-angle-fill');		
			if(scList.includes($(this).attr("id")) == false){
				scList.push($(this).attr("id"));
			} else {
				scList.splice(scList.indexOf($(this).attr("id")),1);
			}
			$('#scrap_count').text($('.bi-pin-angle-fill').length);
  			scstr = scList.join();
  			
    	});
	});
	
    $(function() {
        $("#scrap_check").on("click", function() {
        	
        	if (confirm("스크랩 목록에 추가되었습니다!\n스크랩으로 이동하시겠습니까?")) {
        		if(scstr != ""){
        			location.href = "/topp/views/trip/scrapView.jsp?scList="+ scstr +"";
        		} else {
        			alert("스크랩 목록이 없습니다. 다시 확인해주세요");
        			return;
        		}
        	} else {
        		return;
        	}
    	});   
	});   			
</script>

</head>
<body>
	<header>
		<%@ include file="/views/common/menubar.jsp"%>
	</header>
	<div id="wrap">
		<div class="search_header">
			<!-- 여행정보 검색 -->
			<h1 class="searchTitle">
				여행정보 검색
				<h6 style="color: red">*화면 비율 90%*</h6>
			</h1>
			<form action="/topp/tlist" method="post" name="fr"
				onsubmit="return check()">
				<!-- 여행 검색바 -->
				<div class="searchBar">
					<input id="searchText" type="text" name="searchTrip"
						placeholder="   여행가고 싶은 곳을 입력해주세요." onfocus="this.placeholder=''"
						onblur="this.placeholder='   여행가고 싶은 곳을 입력해주세요.'" size="50"
						style="border: 0; width: 500px; height: 33px;">
					<button class="btn_search_submit" type="submit" onclick="search">
						<i class="bi bi-search" style="font-size: 1.5rem"></i>
					</button>
				</div>
				<h6
					style="width: 500px; text-align: left; margin: 0 auto; margin-bottom: 30px; color: LightSkyBlue">
					<b>#강릉 &nbsp; #제주 &nbsp; #여수</b>
				</h6>
				<!-- 카테고리 체크박스 -->
				<div class="searchChk">
					<h5
						style="display: inline-block; margin-right: 10px; margin-left: 20px;">상세검색</h5>
					<label><input type="checkbox" name="tripCate"
							value="cate_01" checked="checked" onclick="getCheckboxValue()">관광지</label>
					<label><input type="checkbox" name="tripCate"
							value="cate_02" checked="checked" onclick="getCheckboxValue()">맛집</label>
					<label><input type="checkbox" name="tripCate"
							value="cate_03" checked="checked" onclick="getCheckboxValue()">액티비티</label>
					<label><input type="hidden" name="tripCate" value="cate_04"
							checked="checked" onclick="getCheckboxValue()"></label>
				</div>
			</form>
		</div>
		<%
		if (tlist != null) {
		%>
		<div class="searchView">
			<!-- 왼쪽 & 오른쪽 제목 -->
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
				<!-- 블로그 리스트 출력 -->
				<%
				for (Trip s : slist) {
				%>
				<ul class="blog_list_total">
					<li class="bbx">
						<div class="blog_box">
							<a class="blog_thumb" href="<%=s.getBlogLink()%>" target="_blank">
								<img class="blog_thumb" src=<%=s.getBlogThumb()%>>
							</a>
							<div class="blog_conbox">
								<div class="blog_title">
									<h5>
										<%=s.getBlogTitle()%></h5>
								</div>
								<div>
									<%=s.getBlogName()%></div>
							</div>
							<button class="btn_scrap" id="<%=s.getBlogNo()%>">
								<i class="bi bi-pin-angle"
									style="font-size: 1.5rem; margin-left: 10px;"></i>
							</button>
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
					<!-- 관광 리스트 출력 -->
					<%
					for (Trip t : tlist) {
					%>
					<ul class="trip_list_total">
						<li class="tbx">
							<div class="trip_box cate_<%=t.getTripNo().substring(5, 7)%>">
								<a class="trip_thumb" href="#" target="_blank"> <img
									class="trip_thumb" src=<%=t.getTripThumb()%>>
								</a>
								<div class="trip_conbox">
									<div class="trip_title">
										<h5><%=t.getTripName()%></h5>
									</div>
									<div class="trip_content"><%=t.getTripContent()%></div>
								</div>
								<button class="btn_scrap" id="<%=t.getTripNo()%>">
									<i class="bi bi-pin-angle"
										style="font-size: 1.5rem; margin-left: 20px;"></i>
								</button>
							</div>
						</li>
					</ul>
					<%
					}
					%>
				</div>
			</div>
		</div>
		<!-- 오른쪽 서브메뉴바 -->
		<div id="quick_menu2" class="fixed">
			<div class="quick_contents">
				<div style="width: 100px;">
					<!-- 스크랩 확인용 캘린더 및 스크랩 개수 -->
					<button id="scrap_check" style="color: LightCoral;">
						<i class="bi bi-calendar-event"
							style="font-size: 3rem; vertical-align: top; color: DimGray;"></i>
						<span id="scrap_count"></span>
					</button>
				</div>
				<!-- top 버튼 -->
				<div class="btn_quick_top">
					<a href="#Top"><i class="bi bi-caret-up"
						style="font-size: 3rem; color: DimGray;"></i></a>
				</div>
			</div>
		</div>
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