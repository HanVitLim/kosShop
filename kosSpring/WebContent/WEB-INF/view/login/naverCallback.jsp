<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.parser.JSONParser"%>
<%@page import="org.apache.log4j.LogManager"%>
<%@page import="org.apache.log4j.Logger"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<%
		Logger log = LogManager.getLogger(this.getClass());
	
		String clienId = "7hW1pfd7X3emmPVpwIQt";
		String clientSecret = "C7YeHk3Ezv";
		
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		
		
		String redirectURI = URLEncoder.encode("http://localhost:8088/kosSpring/naverCallback.ihv", "UTF-8");
	
		String apiURL;
				apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
				apiURL += "client_id=" + clienId;
				apiURL += "&client_secret=" + clientSecret;
				apiURL += "&redirect_uri=" + redirectURI;
				apiURL += "&code=" + code;
				apiURL += "&state=" + state;
				
		String access_token = "";
		String refresh_token = "";
		
		log.info("apiURL >>> : " + apiURL);
		
		try{
			
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			
			int responseCode = con.getResponseCode();
			
			log.info(responseCode);
			
			if(responseCode == 200){
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				
				String inputLine = "";
				StringBuffer res = new StringBuffer();
				
				while ((inputLine = br.readLine()) != null){
					res.append(inputLine);
				}
				log.info(res.toString());
				
				br.close();
				
				JSONParser jsonParser = new JSONParser();
				JSONObject jsonObject = (JSONObject) jsonParser.parse(res.toString());
				
				access_token = (String)jsonObject.get("access_token");
				log.info("access_token >>> : " + access_token);
				
				request.setAttribute("access_token", access_token);
				
				RequestDispatcher rd = request.getRequestDispatcher("/naverlogin.ihv");
				
				rd.forward(request, response);
				
			}
			
		}catch(Exception e){
			log.info(e);
		}
		
	
	%>
	
	</body>
</html>