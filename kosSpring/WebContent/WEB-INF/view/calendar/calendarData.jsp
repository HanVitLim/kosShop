<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<% Object obj = request.getAttribute("jsonCalendar");
	JSONArray jsonCalendar = null;
	if(obj != null){
		jsonCalendar = (JSONArray)obj;
		System.out.println("jarr >> : " + jsonCalendar);
		out.println("jarr >> : " + jsonCalendar);
		
	}
	
	Object obj1 = request.getAttribute("nCnt");
	if(obj1 != null){
		int nCnt = ((Integer)obj1).intValue();
		out.println("nCnt >>> : " + nCnt);
	}
	
	
%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	</body>
</html>
<?xml version='1,0' encoding='UTF-8'?>
<calendar>
	<result><%= jsonCalendar %></result>
</calendar>