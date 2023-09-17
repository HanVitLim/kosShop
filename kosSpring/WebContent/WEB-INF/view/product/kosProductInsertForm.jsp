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
				
				$("#kpbtn").click(function(){
					
					$("#productForm").attr({
						"action" : "kosProductInsert.ihv",
						"method" : "POST",
						"enctype" : "multipart/form-data"
						
					}).submit();
				
				});
				
			});
		
		
		</script>
	</head>
	<body>
		<h3 style="text-align:center;">kosmoProductInsertForm.jsp</h3>
		<hr>
		<form name="productForm" id="productForm">
			<table border="1" align="center">
				<tr>
					<td colspan="2" align="center">상품등록</td>
				</tr>
				<tr>
					<td>상품번호</td>
					<td><input type="text" name="kpnum" id="kpnum" style="width:150px" readonly></td>
				</tr>
				<tr>
					<td>상품아이디</td>
					<td><input type="text" name="kpid" id="kpid" style="width:150px"></td>
				</tr>
				<tr>
					<td>상품이름</td>
					<td><input type="text" name="kpname" id="kpname" style="width:300px"></td>
				</tr>
				<tr>
					<td>제조사</td>
					<td><input type="text" name="kpcompany" id="kpcompany" style="width:300px"></td>
				</tr>
				<tr>
					<td>상품이미지</td>
					<td><input type="file" name="kpfile" id="kpfile"></td>
				</tr>
				<tr>
					<td>상품수량</td>
					<td><input type="text" name="kpcnt" id="kpcnt" style="width:50px"></td>
				</tr>
				<tr>
					<td>상품가격</td>
					<td><input type="text" name="kpprice" id="kpprice" style="width:150px"></td>
				</tr>
				<tr>
					<td>상품설명</td>
					<td><textarea rows="10" cols="50" name="kpdesc" id="kpdesc"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="button" value="상품등록" id="kpbtn"></td>
				</tr>
			</table>
		</form>
	</body>
</html>