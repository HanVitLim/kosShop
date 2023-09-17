<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="a.b.c.com.kos.mem.vo.KosMemberVO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Login Session Testing :: LOGIN SUCCESS</h3>
	<%
		Object obj = request.getAttribute("listLogin");
		if(obj == null) return;
		
		List<KosMemberVO> list = (List<KosMemberVO>)obj;
		int nCnt = list.size();
		
		if(nCnt == 1){
			String mid = list.get(0).getMid();
		
	%>
	
		<script >
			alert("<%= mid %> 님 로그인 성공");
			setTimeout(function(){location.reload()},500);

		</script>
		<%} %>
</body>
</html>