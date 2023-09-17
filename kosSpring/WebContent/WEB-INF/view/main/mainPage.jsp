<%@page import="a.b.c.com.kos.mem.vo.KosMemberVO"%>
<%@page import="java.util.List"%>
<%@page import= "java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>MAIN PAGE</title>
		<meta name="viewport" content="width=device-width, initial-scale=1"> 
		<script type="text/javascript" src="/kosSpring/js/common.js"></script>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<link rel="stylesheet" href="/kosSpring/include/css/mainstyle.css">
		<link rel="stylesheet" href="/kosSpring/css/main.css">
		<script type="text/javascript">
		
		$(document).ready(function(){
			
			$(function(){
				
				function printTime(){
					let days = ["일", "월", "화", "수", "목", "금", "토"];
					let md = new Date();
					
					let yy = md.getFullYear();
					let mm = md.getMonth() + 1;
					let dd = md.getDate();
					let ii = md.getDay();
					let di = days[ii];
					let hh = md.getHours();
					let mi = md.getMinutes();
					let ss = md.getSeconds();
					
					let time = yy + "년" + 
							   numpad(mm) + "월" + 
							   numpad(dd) + "일" + 
							   di + "요일" + 
							   numpad(hh) + ":" + 
							   numpad(mi) + ":" + 
							   numpad(ss);
							   
					document.getElementById("timer").innerHTML=time;
				}
				
				setInterval(printTime, 1000);
				
				function getDay(y, m, d){
					let today = new Date();
					let dday = new Date(y, m-1, d);
					let cnt = dday.getTime() - today.getTime();
					let n = Math.ceil(cnt / (24*60*60*1000));
					return n;
					
				}
				let dday = getDay(2023, 8, 8);
				document.getElementById("dday").innerHTML=dday;
				
				
			});
			
			$(document).on('click', '#img_1', function(){
				alert("#상품 아이디 가지고 상품 검색 하기");
			});
			
			$(document).on('click','#dollar',function(){
				$("#dollar_chart").css("visibility","visible");
				$("#yen_chart").css("visibility","hidden");
				$("#euro_chart").css("visibility","hidden");
			});
			
			$(document).on('click','#yen',function(){
				$("#dollar_chart").css("visibility","hidden");
				$("#yen_chart").css("visibility","visible");
				$("#euro_chart").css("visibility","hidden");
			});
			
			$(document).on('click','#euro',function(){
				$("#dollar_chart").css("visibility","hidden");
				$("#yen_chart").css("visibility","hidden");
				$("#euro_chart").css("visibility","visible");
			});
			
		});
		
		</script>
		<style type="text/css">
		
	.m {
		text-align: center;
	}
	
	table{
		margin : auto;
		border-collapse: separate;
		border-spacing: 20px 40px;
	}
	
	img {
		width:200px;
		height:250px;
	}
	
	a {
	  	text-decoration-line: none;
		/*   text-decoration-line: underline; */
		/*   text-decoration-line: overline; */
		/*   text-decoration-line: line-through; */
		/*   text-decoration-line: underline line-through overline; */
	}		
	div.chart_{
		position:absolute;
		top:0px;
	}
	<!--
		슬라이드 메뉴 
	-->
	#header { width: 100%; height: 52px; background: #447e65; position: relative; overflow: hidden; }
	#mask { width: 100%; height: 100%; position: fixed; top: 0; left: 0; background: #000; -ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=50)"; filter: alpha(opacity=50); zoom: 1; opacity: 0.5; z-index: 9998; display: none; }
	.logo { font-size: 25px; color: #fff; position: absolute; top: 5px; left: 15px; }
	.btn_menu_open { background: none; border: 0; font-size: 15px; color: #fff; position: absolute; top: 15px; right: 15px; cursor: pointer; }
	.slide_menu { width: 80%; height: 100%; max-width: 360px; background: #fff; position: fixed; top: 0; right: 0; overflow-y: scroll; z-index: 9999; display: none; }
	.slide_menu .menu_close { width: 100%; height: 52px; background: #447e65; position: relative; }
	.slide_menu .btn_menu_close { background: none; border: 0; font-size: 15px; color: #fff; position: absolute; top: 15px; right: 15px; cursor: pointer; }
	.slide_menu .menu_list li { padding: 15px; border-bottom:1px solid #ccc; list-style: none; }
	.slide_menu .menu_list li a { font-size: 15px; color: #333; }
		</style>
		
	</head>
		<body>
			<div id="sitearea">
				<header id="topbar">
				<div class="wrapper">
					<div id="logoarea">
						<div id="toplogo">
							<a href="/kosSpring/index.jsp">
								<img src="/kosSpring/include/img/11112222.jpg" id="sitelogo">
							</a>
						</div>
						<div id="searchbar">
							<form>
								<select>
									<option>전체</option>
									<option>상품명</option>
									<option>날짜</option>
								</select>
								<div id="searchtext">
									<input type="text">
								</div>
								<input type="submit" value="검색" id="searchbtn">
							</form>
						</div>
					</div>
					<div id="btnarea">
					<%
						String mid = "";
						Object obj = request.getAttribute("listLogin");
						
						if(obj != null){
							
							List<KosMemberVO> list = (List<KosMemberVO>)obj;
							int nCnt = list.size();
							if(nCnt == 1){
								mid = list.get(0).getMid();
							}
						
					%>
						<p align="right">
						<%= mid %>	님 로그인 중<a href="logout.ihv" class="sitebtn">로그아웃</a>
							<a href="javascript:alert('준비중입니다.');" onfocus="this.blur()" class="sitebtn">마이페이지</a>
							<a href="javascript:alert('준비중입니다.');" onfocus="this.blur()" class="sitebtn">글쓰기</a>
						</p>
						<%} else{%>
						<p align="right">
							<a href="loginForm.ihv" class="sitebtn">로그인</a>
							<a href="javascript:alert('준비중입니다.');" onfocus="this.blur()" class="sitebtn">회원가입</a>
						</p>
						<% } %>
						<h3 class="m">MAIN PAGE : 
						<span style="color:red">수료일 D-</span><span id="dday" style="color:red"></span> : <span id="timer"></span>
						</h3>
					</div>
					</div>
					<div id="naviarea">
						<ul class="wrapper">
							<li>
								<a href="kosBoardSelectAll.ihv" onfocus="this.blur()">
									<div class="nav_btn">
										게시판
									</div>
								</a>
							</li>
							<li>
								<a href="javascript:alert('준비중입니다.');" onfocus="this.blur()">
									<div class="nav_btn">
										상품
									</div>
								</a>
							</li>
							<li>
								<a href="javascript:alert('준비중입니다.');" onfocus="this.blur()">
									<div class="nav_btn">
										장바구니
									</div>
								</a>
							</li>
							<li>
								<a href="javascript:alert('준비중입니다.');" onfocus="this.blur()">
									<div class="nav_btn">
										결제
									</div>
								</a>
							</li>
						</ul>
					</div>
				</header>
				<div id="contents">
					<h1>KOSMO 129기</h1>
				</div>
				<div id="sitecontent">
					<div class="wrapper" >
						<div>
							[차트]<br>
							<a id="dollar">달러 횐율</a>&nbsp;|
							<a id="yen">엔 환율</a>&nbsp;|
							<a id="euro">유로 환율</a>
							<hr>
							<div>
							<div style="position:relative;">
							<div id="dollar_chart" class="chart_"><jsp:include page="dollar_chart.jsp"></jsp:include></div>
							<div id="yen_chart"  class="chart_" style="visibility:hidden;"><jsp:include page="yen_chart.jsp"></jsp:include></div>
							<div id="euro_chart"  class="chart_" style="visibility:hidden;"><jsp:include page="euro_chart.jsp"></jsp:include></div>
							</div>
							<div style="padding-top:500px;">
							[내용]
							<table>
								<tr>
									<td><img src="/kosSpring/img/img_book/book0.jpg" id="img_1"><br>
										<a href="void(0);" onclick="alert('상품아이디가지고 상품 검색하기'; return false;)"> 책 1</a>
									</td>
									<td><img src="/kosSpring/img/img_book/book1.jpg"><br><a href="#">책 2
									</a>
									</td>
									<td><img src="/kosSpring/img/img_book/book2.jpg"><br><a href="#">책 3
									</a>
									</td>
									<td><img src="/kosSpring/img/img_book/book3.jpg"><br><a href="#">책 4
									</a>
									</td>
								</tr>
								<tr>
									<td><img src="/kosSpring/img/img_kakaofriends/04 (2).png"><br><a href="#">친구 1
									</a>
									</td>
									<td><img src="/kosSpring/img/img_kakaofriends/08.png"><br><a href="#">친구 2
									</a>
									</td>
									<td><img src="/kosSpring/img/img_kakaofriends/1__(3).png"><br><a href="#">친구 3
									</a>
									</td>
									<td><img src="/kosSpring/img/img_kakaofriends/2 (3).png"><br><a href="#">친구 4
									</a>
									</td>
								</tr>
								<tr>
									<td><img src="/kosSpring/img/img_css/bear.jpg"><br><a href="#">이미지 1
									</a>
									</td>
									<td><img src="/kosSpring/img/img_css/guitar-bg.jpg"><br><a href="#">이미지 2
									</a>
									</td>
									<td><img src="/kosSpring/img/img_css/cat.jpg"><br><a href="#">이미지 3
									</a>
									</td>
									<td><img src="/kosSpring/img/img_css/photo.jpg"><br><a href="#">이미지 4
									</a>
									</td>
								</tr>
							</table>
							[지도]
							<%@ include file="k_map_7.html" %>
							</div>
						</div>
					</div>
				</div>
			</div>
			<footer id="footerarea">
				<div class="wrapper">
					<div>
						[하단바]
						<br>아이콘 제작자 : 
						<a href="http://www.freepik.com/" title="Freepik">Freepik</a>
						from
						<a href="https://www.flaticon.com/kr/" title="Flaticon">www.flaticon.com</a>
					</div>
				</div>
			</footer>
		</body>
</html>