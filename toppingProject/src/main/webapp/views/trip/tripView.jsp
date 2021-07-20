<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, trip.model.vo.Trip"%>
<%
ArrayList<Trip> list = (ArrayList<Trip>) request.getAttribute("list");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<title>topp</title>
<script type="text/javascript">
	function getCheckboxValue() {
		// 선택된 목록 가져오기
		const query = 'input[name="tripCate"]:checked';
		const selectedEls = document.querySelectorAll(query);
		alert("안녕");
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
	
</script>
<style type="text/css">
@import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap')
	;

* {
	font-family: 'Noto Sans KR', sans-serif;
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
	margin: auto;
	margin-top: 40px;
}

.bx {
	list-style: none;
}

.blog_main {
	margin-left: 30px;
	float: left;
	width: 580px;
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
	border-left: solid 1px black;
	float: left;
}

.trip_main::-webkit-scrollbar {
	width: 15px;
	background-color: black;
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
}
</style>
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
					<label><input type="checkbox" name="tripCate" value="01"
							checked="checked" onclick="getCheckboxValue()">관광지</label> <label><input
							type="checkbox" name="tripCate" value="02" checked="checked"
							onclick="getCheckboxValue()">맛집</label> <label><input
							type="checkbox" name="tripCate" value="03" checked="checked"
							onclick="getCheckboxValue()">액티비티</label> <label><input
							type="checkbox" name="tripCate" value="04" checked="checked"
							onclick="getCheckboxValue()">숙박</label>
				</div>
			</form>
		</div>
		<%
		if (list != null) {
		%>
		<div class="searchView">
			<!-- SNS 검색목록 -->
			<div class="blog_main">
				<h4 style="text-align: center; margin-bottom: 35px;">SNS 검색목록</h4>
				<h6 style="text-align: center;"></h6>
				<!-- 부제목 칸 -->
				<ul class="blog_list_total">
					<li class="bx" id="blog_1">
						<div class="blog_box">
							<a class="blog_thumb"
								href="https://blog.naver.com/priti1?Redirect=Log&logNo=222421448739">
								<img class="blog_thumb"
								src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA3MDVfNTMg%2FMDAxNjI1NDg5NjI5NDc0.MW6w7yxhMI-XGXYiDr48E_RPsZiIB9g3Yldv8nV7U88g.qqowWlRQ9spzipJkObEw9ljCATw7KqXF-VyZZZoF0oAg.JPEG.priti1%2F20210628_112619.jpg%234032x2268&type=ff264_180">
							</a>
							<div class="blog_conbox">
								<div>
									<h5>제목</h5>
								</div>
								<div>내용</div>
							</div>
						</div>
					</li>
				</ul>
			</div>
			<!-- 관광지 상세정보 목록 -->
			<div class="trip_main">
				<h4 style="text-align: center; margin-bottom: 35px;">관광지 검색목록</h4>
				<div class="trip_contents">
					<h6 style="text-align: center;"></h6>
					<!-- 부제목 칸 -->
					<%
					for (Trip t : list) {
					%>
					<ul class="trip_list_total">
						<li class="bx" id="trip_1">
							<div class="trip_box">
								<div style="display: none;">
									<span><%=t.getTripNo()%></span>
								</div>
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
		<br>
		<br>
		<h1 style="text-align: center;">
			여행검색 페이지<i class="bi bi-heart-fill"
				style="font-size: 2rem; color: Red;"></i>
		</h1>
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