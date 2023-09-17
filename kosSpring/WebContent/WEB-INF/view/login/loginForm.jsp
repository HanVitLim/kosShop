<%@page import="java.math.BigInteger"%>
<%@page import="java.security.SecureRandom"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	// 네이버 로그인
	String clientId = "7hW1pfd7X3emmPVpwIQt";
	String redirectURI = URLEncoder.encode("http://localhost:8088/kosSpring/naverCallback.ihv", "UTF-8");
	
	SecureRandom random = new SecureRandom();
	String state = new BigInteger(130, random).toString();
	
	String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
		   apiURL += "&client_id=" + clientId;
		   apiURL += "&redirect_uri=" + redirectURI;
		   apiURL += "&state=" + state;
		   
	System.out.println("apiURL >>>> : " + apiURL);	
	session.setAttribute("state", state);


%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- 카카오 로그인 api -->
	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
	<script type="text/javascript">
	
	window.Kakao.init('b246d5972d6525130f02caf093982304'); // 사용하려는 앱의 JavaScript 키 입력
	function kakaoLoginApi(){
		alert("kakaoLoginApi >>> : ");
		
		window.Kakao.Auth.login({
			success: function(authObj){
				
				window.Kakao.API.request({
					url: '/v2/user/me',
					success : function(res){
						console.log("res >>> : " + JSON.stringify(res));
						
						let k_id = res.id;
						let k_email = res.kakao_account.email;
						let k_gender = res.kakao_account.gender;
						let k_nickname = res.properties.nickname;
						let k_profile_image = res.properties.profile_image;
						//let k_thumnail_image = es.properties.thumbnail_image;
						
						console.log("k_id >>> : " + k_id);
						console.log("k_email >>> : " + k_email);
						console.log("k_gender >>> : " + k_gender);
						console.log("k_nickname >>> : " + k_nickname);
						console.log("k_profile_image >>> : " + k_profile_image);
						//console.log("k_thumnail_image >>> : " + k_thumnail_image);
						
						kakaoLogin(k_id, k_email);
					}
					
				});
				
			}
			
		});
		
	}
	
	function kakaoLogin(k_id, k_email){
		alert("kakaoLogin >>> : " + k_id + " : " + k_email);
		
		var url1 = 'kakaoLogin.ihv';
		var datatype = 'GET';
		var data1 = {
				snsid : k_id,
				snstype : "01",
				snsemail : k_email
		}

//  		$.ajax({
//  			url : url1,
//  			type : datatype,
//  			data : data1,
//  			success : function(res){
//  				alert(res);
//  				console.log(res);
				location.href="/kosSpring/kakaoLogin.ihv?snstype=01&snsid="+k_id+"&snsemail="+k_email;
//  			}
			
//  		})
		
		
	}

		
// 		 function kakakoLogout(){
			 
// 				Kakao.Auth.logout().then(function(response) {
// 				    console.log(Kakao.Auth.getAccessToken()); // null
// 				  }).catch(function(error) {
// 				    console.log('Not logged in.');
// 				  });
				
// 				Kakao.API.request({
// 					  url: '/v1/user/unlink',
// 					}).then(function(response) {
// 					    console.log(response);
// 					  }).catch(function(error) {
// 					    console.log(error);
// 					  });
				
// 				}
		 
		alert("자바스크립트 블럭 시작 >>> : ");
	
		$(document).ready(function(){
			
			$("#loginBtn").click(function(){
				
				$("#loginForm").attr({
					"action" : "loginCheck.ihv",
					"method" : "POST",
					'enctype':'application/x-www-form-urlencoded'
				}).submit();
				
			});
			
			$("#btn").click(function(){
				
				kakakoLogout();
			});
			
		});
	
	</script>
</head>
<body>
	<div class="div1">
		<h1 align="center">Login Test</h1>
	<hr>
	<form name="loginForm" id="loginForm">
		<table border="1" align="center">
		<tr>
			<td><input type="text" name="mid" id="mid" style="width:200px;"></td>
		</tr>
		<tr>
			<td><input type="password" name="mpw" id="mpw" style="width:200px;"></td>
		</tr>
		<tr>
			<td>
			<button type="button" id="loginBtn" style="width:208px; background-color: yellow;">로그인</button>
			</td>
		</tr>
		<tr>
			<td align="right">
			<a href=""><font size="2">아이디찾기</font></a> | 
			<a href=""><font size="2">비밀번호찾기</font></a>
			<input type="button" id="btn" value="로그아웃">
			</td>
		</tr>
		<tr>
			<td>
				<a href="javascript:kakaoLoginApi()"><img height="30" width="208" src="/kosSpring/img/img_sns/o.jpg"></a>
			</td>
		</tr>
		<tr>
			<td>
				<a href="<%= apiURL%>"><img height="30" width="208" src="/kosSpring/img/img_sns/naver.PNG"></a>
			</td>
		</tr>
		</table>
	</form>
	</div>

</body>
</html>