<%@page import="a.b.c.com.kos.board.vo.KosBoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
		
			$(document).ready(function(){
				
				sellectAll();
				
				$("#insertBtn").click(function(){
					
					location.href="kosBoardInsertForm.ihv";
					
				});
				
				$("#selectAllBtn").click(function(){
				
					location.href="kosBoardSelectAll.ihv";
					
				});
				
				$("#like_cnt_1").click(function(){
					
					let likeurl = "like_cnt_1click.ihv";
					let liketype = "POST";
					let likedata = { bnum : $("#bnum").val(),
									 
					}
					
					$.ajax({
						url : likeurl,
						type : liketype,
						data : likedata,
						success : whenSuccess,
						error : whenError
					});
					
					function whenSuccess(resData){
						alert(resData);
						
						var like1 = resData;
						
						if(like1 == "NO"){
							
							alert("로그인 해주세요 !!");
							
							location.href="loginForm.ihv";
							
						}else{
							
							var like = like1.split(',');
							
							alert(like[1] + " : " + like[0])
							$("#disp_cnt_stop").text(like[1]);
							$("#disp_cnt_recom").text(like[0]);
							
						}
					}
					
					function whenError(e){
						
						alert("e >>> : " + e.responseText);
					}
					
				});
				
				
				function sellectAll(){
					
						let likeurl = "kosBoardLikeSelectAll.ihv";
						let liketype = "POST";
						let likedata = $("#boardUpdateForm").serialize();
						
						$.ajax({
							url : likeurl,
							type : liketype,
							data : likedata,
							success : whenSuccess,
							error : whenError
						});
						
						function whenSuccess(resData){
							alert(resData);
							var like1 = resData;
							
							var like = like1.split(',');
							
							alert(like[1] + " : " + like[0])
							$("#disp_cnt_stop").text(like[1]).val();
							$("#disp_cnt_recom").text(like[0]).val();
							
						}
						
						function whenError(e){
							
							alert("e >>> : " + e.responseText);
						}
					}
				
				$("#like_cnt_2").click(function(){
					
					let likeurl = "like_cnt_2click.ihv";
					let liketype = "POST";
					let likedata = { bnum : $("#bnum").val()
					}
					
					$.ajax({
						url : likeurl,
						type : liketype,
						data : likedata,
						success : whenSuccess,
						error : whenError
					});
					
					function whenSuccess(resData){
						alert(resData);
						
						var like1 = resData;
						
						if(like1 == "NO"){
							
							alert("로그인 해주세요 !!");
							
							location.href="loginForm.ihv";
							
						}else{
							
							var like = like1.split(',');
							
							alert(like[1] + " : " + like[0])
							$("#disp_cnt_stop").text(like[1]).val();
							$("#disp_cnt_recom").text(like[0]).val();
							
						}
					}
					
					function whenError(e){
						
						alert("e >>> : " + e.responseText);
					}
					
				});
				
			});
		
		</script>
		
		<style type="text/css">
	
			div {		 
				margin: 0 auto; 		
				border:1px solid #6d82f3;
				display:table;
			}			
		
			table, hd, h3 {
				text-align: center;
				border: 1px;
			}
			
			table {
				width: 100%;
				border: 1px solid #444;
				border-collapse: collapse;
		  	}
			
			th, td {
				border: 1px solid #444;
				padding: 10px;
			}
			
			.td_1 {
				font-size: 12px;
				color: black;		
			}
			
			.td_2 {
				font-size: 12px;
				color: black;
				text-align:right;
			}
			
		</style>
		
	</head>
	<body>
		<h3>게시글 내용</h3>
		<hr>
		<div>
			<%
				Object obj = request.getAttribute("select");
				List<KosBoardVO> list = (List<KosBoardVO>)obj;
				
				KosBoardVO kbvo = list.get(0);
			
			%>
			<form name="boardUpdateForm" id="boardUpdateForm">
				<table>
					<tr>
						<td>제목</td>
						<td colspan="4" style="text-align:left; width:400;">
							<font size="4" style="color:black;"><%= kbvo.getBsubject() %></font>
							<input type="hidden" name="bnum" id="bnum" value="<%= kbvo.getBnum()%>">
 							<input type="hidden" name="mnum" id="mnum" value="">
						</td>
						<td class="td_2"> 추천   &nbsp; 조회 <%= kbvo.getBhit() %>&nbsp; 작성일자 : <%= kbvo.getUpdatedate() %></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><%= kbvo.getBname() %></td>
						<td>카테고리</td>
						<td>상세</td>
					</tr>
					<tr>
						<td colspan="6" style="texe-align:left;">
							<img src="/kosSpring/fileupload/board/<%= kbvo.getBfile() %>" border="1" width="100" height="100" alt="image"><br>
							<img src="/kosSpring/fileupload/board/<%= kbvo.getBfile() %>" border="1" width="200" height="100" alt="image">
						</td>
					</tr>
					<tr>
						<td colspan="6" style="text-align:left">
						<textarea name="kbcontent" id="kbcontent" rows="5" cols="100"><%= kbvo.getBcontent() %></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="6" style="text-algin:center">
							<button type="button" class="like_1" name="like_cnt_1" id="like_cnt_1"> 추천
							<p>
								<img src="/kosSpring/img/img_board/heart.png" style="width:12px; margin:3px 3px 0 0;">
								<span id="disp_cnt_recom"></span>
							</p>
							</button>
							<button type="button" class="like_2" name="like_cnt_2" id="like_cnt_2">반대
							<p>
								<img src="/kosSpring/img/img_board/thumb_rev.png" style="width:12px; margin: 3px 3px 0 0;">
								<span id="disp_cnt_stop"></span>
							</p>
							</button>
							<button type="button" class="like_3" name="like_3" id="like_3">신고
							<p>
								<img src="/kosSpring/img/img_board/alarm.png" style="width:18px; margin-top:1px;">
							</p>
							</button>
						</td>
					</tr>
					<tr>
					<td colspan="6" align="center">
						<button type="button" id="insertBtn">글쓰기</button>
						<button type="button" id="selectAllBtn">글목록</button>
					</td>
					</tr>
				</table>
			</form>
		</div>
		<jsp:include page="/WEB-INF/view/rboard/rboardForm.jsp">
			<jsp:param value="<%= kbvo.getBnum() %>" name="bnum"/>
		</jsp:include>
	</body>
</html>