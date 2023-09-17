<%@page import="a.b.c.com.common.NumUtill"%>
<%@page import="a.b.c.com.kos.product.vo.KosProductVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="/kosSpring/js/common.js"></script>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
		
			$(document).ready(function(){
				
				$("#kpcnt").change(function(){
					
					var pricesum1 = parseInt($("#kpcnt").val());
					
					var pricesum2 = parseInt($("#kpprice").val());
					
					var pricesum = comma(pricesum1 * pricesum2);
					
					$("#kppricesum").val(pricesum);
				
				});
				
// 				$.ajax({
// 					url : "loginCheckAjax.ihv",
// 					type : "POST",
// 					success : whenSuccess,
// 					error : whenError,
// 				})
				
				
// 				function whenSuccess(resData){
						
// 					if(resData != "null"){
// 					alert(resData)
// 					$("#mid").val(resData);
// 					alert($("#mid").val());
// 					}
// 				}
				
// 				function whenError(e){
// 					alert("e >>> : " + e.responseText)
// 				}
				
				
				$("#cartBtn").click(function(){
					
					if($("#mid").val() == "0"){
					
						alert('로그인 해주세요!');
						
						$("#productSelectForm").attr({
							"action" : "loginCart.ihv",
							"method" : "GET"
						}).submit();
						
					}else{
					
					if($("#kppricesum").val() == "0" ){
						alert("구매 수량을 추가 해주세요!");
						
					}else{
						
						$("#productSelectForm").attr({
							"action" : "koscartInsert.ihv",
							"method" : "GET"
							
						}).submit();
						
					}
					
					}
				});
				
				
			});
		
		</script>
	
		<style type="text/css">

				table {		
				    margin: 20px auto;	     
				}
			
				table, td, th {
				    border-collapse : collapse;
				    border : 1px solid black;
			};
		</style>
	</head>
	<body>
	<% Object obj = request.getAttribute("listS");
		
		List<KosProductVO> lists = (List<KosProductVO>)obj;
		
		KosProductVO _kpvo = lists.get(0);
		
		Object obj2 = request.getAttribute("kid");
		String kid = (String)obj2;
		
		
		
	%>
		<h3>kosmoProductSelect.jsp</h3>
		<hr>
		<div>
			<form name="productSelectForm" id="productSelectForm">
				<table>
					<tr>
						<td rowspan='7' align='center' vertical-align="middle" style="width:200px;">
							<img src="/kosSpring/fileupload/product/<%= _kpvo.getKpfile() %>" width="130" height="130">
						</td>
						<td align="center" colspan="2">
							<input type='text' name="kpname" id="kpname" value="<%= _kpvo.getKpname() %>" style="width:300px; text-align:center;" readonly>
						</td>
					</tr>
					<tr>
						<td align="right" colspan="2">
							<input type="text" name="kpprice" id="kpprice" value="<%= _kpvo.getKpprice() %>" style="width:280px; text-align:right;" readonly> &nbsp; 원
						</td>
					</tr>
					<tr>
						<td><label align="left">수량</label></td>
						<td align="right">
							<select name="kpcnt" id="kpcnt" style="width:200px;">
								<option value="0">수량</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><label align="left"> 총 합계 :</label></td>
						<td align="right">
							<input type="text" name="kppricesum" id="kppricesum" value="0" style="width:170px; text-align:right;" readonly> &nbsp; 원
						</td>
					</tr>
					<tr>
						<td align="center" colspan="2">
							<input type="hidden" name="kpfile" id="kpfile" value="<%= _kpvo.getKpfile()%>">
							<input type="hidden" name="kpid" id="kpid" value="<%= _kpvo.getKpid()%>">
							<input type="hidden" name="kpnum" id="kpnum" value="<%= _kpvo.getKpnum()%>">
							<input type="hidden" name="kmnum" id="kmnum" value="">
							<input type="hidden" name="mid" id="mid" value="<%= kid%>">
							<input type="button" id="cartBtn" value="장바구니" style="width: 150px;">
							<input type="button" id="stockBtn" value="재고확인" style="width: 155px;">
						</td>
					</tr>
					<tr>
						<td align="center" colspan="2">
							<input type="button" id="orderBtn" value="구매하기" style="width:310px;">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>