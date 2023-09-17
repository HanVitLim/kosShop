<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style type="text/css">
	
		h3 {
			text-align:center;
		}
	</style>
</head>
<body>
	<h3>Login Session Testing :: LOGOUT SUCCESS</h3>
	<h3>3초 후  index.jsp 페이지로 이동</h3>
	<hr>
	<script >
		setTimeout("location.href='http://localhost:8088/kosSpring/index.jsp'",3000);
	</script>
</body>
</html>