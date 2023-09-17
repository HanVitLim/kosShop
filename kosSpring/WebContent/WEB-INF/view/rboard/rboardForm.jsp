<%@page import="org.apache.log4j.LogManager"%>
<%@page import="org.apache.log4j.Logger"%>
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
				
				
				selectAll();
				
				$(document).on("click", "#rinsertBtn", function(){
					let insertURL = "kosRboardInsert.ihv";
					let method = "POST";
					let dataParam = $("#rboardForm").serialize();
					
					$.ajax({
						url : insertURL,
						type : method,
						data : dataParam,
						success : whenSuccess,
						error : whenError
					});
					
					function whenSuccess(resData){
						
						if("GOOD" == resData ){
							rboardFormData();
							location.reload();
							selectAll();
						}
						
					}
					
					function whenError(e){
						alert("e >>> : " + e.responseText);
					}
					
				});
				
				$(document).on("click", ".deleteBtn", function(){
					
					var rbnumV = $(this).parents("li").attr("dataNum");
					alert("rbnumV >>> : " + rbnumV)
					var target = $(this).parents(".rbmemoItem");
					alert("target >>> : " + target)
					let insertURL = "kosRboardDelete.ihv";
					let method = "POST";
					$("#rbnum").val(rbnumV);
					let dataParam = $("#rboardForm").serialize();
					
					$.ajax({
						url : insertURL,
						type : method,
						data : dataParam,
						success : whenSuccess,
						error : whenError
					});
					
					function whenSuccess(resData){
						
						if("OK" == resData ){
							target.remove();
						}
					}
					
					function whenError(e){
						alert("e >>> : " + e.responseText);
					}
					
				});
				
				function selectAll(){
					let selctAllURL = "kosRboardSelectAll.ihv";
					let method = "POST";
					let dataParm = {
							bnum: $("#bnum").val(),
					};
					
					dataParam = $("#rboardForm").serialize();
					$.ajax({
						url: selctAllURL,
						type: method,
						data: dataParam,
						success: whenSuccess,
						error: whenError
					
					});
					
					function whenSuccess(resData){
						
						if(isEmpty(resData)){
  							return false;
 						}
						
						let v = resData.split("&");
						for(let i = 0; i < v.length; i++){
							
							let vv = v[i].split(",")
							
							for (let j = 0; j<vv.length-1; j++){
								console.log("vv[0] >>> : " + vv[0]);
								console.log("vv[1] >>> : " + vv[1]);
								console.log("vv[2] >>> : " + vv[2]);
								console.log("vv[3] >>> : " + vv[3]);
							}
							addNewItem(vv[0], vv[1], vv[2], vv[3]);
							
						}
						
					}
					
					function whenError(e){
						console.log("e >>> : " + e.responseText);
					}
					
					
				}
				
				function addNewItem(num, writer, content, datetime){
					
					if(isEmpty(num)) return false;
					
					var newLi = $("<li>");
					newLi.attr("dataNum",num);
					newLi.addClass("rbmemoItem");
					
					var wrtierP = $("<p>");
					wrtierP.addClass("writer");
					
					var nameSpan = $("<span>");
					nameSpan.addClass("name");
					nameSpan.html(decodeURIComponent(writer, "UTF-8") + "님");
					
					var dataSpan = $("<span>");
					dataSpan.html("/" + datetime + " ");
					
					var delInput = $("<input>");
					delInput.attr({
						"type":"button", "value":"삭제하기"
					});
					delInput.addClass("deleteBtn");
					
					var contentP = $("<p>");
					contentP.html(decodeURIComponent(content, "UTF-8"));
					
					wrtierP.append(nameSpan).append(dataSpan).append(delInput);
					newLi.append(wrtierP).append(contentP);
					$("#rboardlist").append(newLi);
					
				}
				
 				function isEmpty(val){
 					console.log("val >>> : " + val);
 					if(typeof val == "undefined" || val == null || val == ""){
 						
 						return true;
 					}else{
 						
 						return false;
 					}
 				}
				
 				function rboardFormData(){
 					$("#rbname").val("");
 					$("#rbcontent").val("");
 				}
 				
			});
		
		</script>
	</head>
	<body>
		<h3 style="text-align:center">댓글</h3>
		<hr>
		<%
			Logger log = LogManager.getLogger(this.getClass());
		
			String bnum = request.getParameter("bnum");
			log.info("rboard >>> : " + bnum);
			
			
		%>
		<div id="rbwriterdiv">
			<form name="rboardForm" id="rboardForm">
				<table>
					<tr>
						<td>작성자</td>
						<td>
							<input type="text" name="rbname" id="rbname">
							<input type="hidden" name="bnum" id="bnum" value="<%= bnum%>">
							<input type="hidden" name="rbnum" id="rbnum">
							<input type="button" value="저장하기" id="rinsertBtn">
						</td>
					</tr>
					<tr>
						<td>덧글 내용</td>
						<td>
							<textarea name="rbcontent" id="rbcontent" style="resize: none" rows="5" cols="50"></textarea>
							<div><span class="bytes">0</span>bytes</div>
						</td>
					</tr>
				</table>
				<hr>
				<ul name = "rboardlist" id="rboardlist">
				</ul>
			</form>
		</div>
	</body>
</html>