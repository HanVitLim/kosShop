<%@page import="org.apache.log4j.LogManager"%>
<%@page import="org.apache.log4j.Logger"%>
<%@page import="a.b.c.com.kos.mem.vo.KosMemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	Object obj = request.getAttribute("listLogin");
	Object obj2 = request.getAttribute("kpnum");
	
	List<KosMemberVO> list = (List<KosMemberVO>)obj;
	
	String kid = list.get(0).getMid();
	String kpnum = (String)obj2;
%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
		$(document).ready(function(){
			
			$("#loginCart").attr({
				"action" : "kosProductSelect.ihv",
				 "method":"GET"
				
			}).submit();
			
		});
		
		</script>

</head>
<body>
	<form id="loginCart">
		<input type="hidden" id="kpnum" name="kpnum" value="<%=kpnum %>">
		<input type="hidden" id="kid" name="kid" value="<%=kid %>">
	</form>
</body>
</html>