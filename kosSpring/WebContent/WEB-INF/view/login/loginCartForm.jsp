<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	Object obj = request.getAttribute("kpnum");
	
	String kpnum = (String)obj;

	
%>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
		alert("자바스크립트 블럭 시작 >>> : ");
	
		$(document).ready(function(){
			
			$("#loginBtn").click(function(){
				
				$("#loginForm").attr({
					"action" : "loginCartCheck.ihv",
					"method" : "POST",
					'enctype':'application/x-www-form-urlencoded'
				}).submit();
				
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
			<td><input type="text" name="mid" id="mid" style="width:200px;">
			<input type="hidden" name="kpnum" id="kpnum" value="<%= kpnum%>">
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
			<a href=""><font size="2">비밀번호찾기<font></a>
			</td>
		</tr>
	</form>
	</div>

</body>
</html>