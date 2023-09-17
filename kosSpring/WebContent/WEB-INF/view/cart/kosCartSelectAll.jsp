<%@page import="a.b.c.com.common.NumUtill"%>
<%@page import="a.b.c.com.kos.cart.vo.KoscartVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="/kosmoSpring/js/common.js"></script>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				
				$(document).on('click', '#chek', function(){
					if($(this).prop('checked')){
						$('.kcnum').prop('checked',true);
					}else{
						$('.kcnum').prop('checked',false);
					}
				});
				
				
				$.ajax({
					url : "loginCheckAjax.ihv",
					type : "POST",
					success : whenSuccess,
					error : whenError,
				})
				
				
				function whenSuccess(resData){
						
					alert(resData)
					$("#mid").val(resData);
				}
				
				function whenError(e){
					alert("e >>> : " + e.responseText)
				}
				
				
				$(document).on('click','.delBtn',function(){
					alert("delBtn >>> : ");
					let kcnumV = $(this).val();
					alert("kcnumV >>> : " + kcnumV);
					
					location.href="koscartDelete.ihv?kcnum="+kcnumV;
					
				});
				
				$(document).on('click', '#delsBtn', function(){
					cart_delete();
				});
				
				$(document).on('click', '#delAllBtn', function(){
					cart_delete();
				});
				
				function cart_delete(){
					if ($('.kcnum:checked').length == 0){
						alert("삭제할 상품 하나 이상을 선택하세요!!");
						return;
					}
					
					var kcnum = [];
					$("input:checkbox[name='kcnum']:checked").each(function(){
						kcnum.push($(this).val());
						console.log(kcnum);
					});
					
					$("#productList").attr({
						"action" : "kosmoCartDeleteArray.ihv",
						"method" : "GET"
					}).submit();
				}
				
				$(document).on('click', '#shopingBtn', function(){
					alert("shopingBtn >>> : ");
					location.href = "koscartSelectAll.ihv";
				});
				
				$(document).on('click', '#buyBtn', function(){
					
					if ($('.kcnum:checked').length == 0){
						alert("구매할 상품 하나 이상을 선택하세요!!");
						return;
					}
					
					$("#productList").attr({
						"action" : "kosOrderInsertForm.ihv",
						"method" : "GET"
					}).submit();
					
					
				});
				
				
			});
		
		
		</script>
	</head>
	<body>
	<% 
		Object obj = request.getAttribute("listcart");
		
		List<KoscartVO> listcart = (List<KoscartVO>)obj;
		
		String kpprice = "";
		String kppricesum = "";
		int sum = 0;
		
	%>
		<h3 align="center">장바구니</h3>
		<hr>
		<form name="productList" id="productList">
			<table border ="1" align="center">
				<thead>
					<tr>
						<td align="center">
							<input type="checkbox" name="chek" id="chek" class="chek">
						</td>
						<td align="center">상품명</td>
						<td align="center">가격</td>
						<td align="center">수량</td>
						<td align="center">합계</td>
						<td align="center">적립금</td>
						<td align="center">배송비</td>
						<td align="center">관심상품/삭제</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="8" align="center">
							<h2>장바구니에 상품을 담으세요</h2>
						</td>
					</tr>
					<tr>
					
					
					<% for(int i = 0; i < listcart.size(); i++){
						KoscartVO _kcvo = listcart.get(i);
						
						kpprice = NumUtill.comma(_kcvo.getKpprice());
						kppricesum = NumUtill.comma(_kcvo.getKppricesum());
						sum += Integer.parseInt(_kcvo.getKppricesum());
						%>

					
						<td align="center">
						<input type="checkbox" name="kcnum" id="kcnum" class="kcnum" value=<%= _kcvo.getKcnum() %>>
						<input type="hidden" name="mnum" id="mnum" value=<%= _kcvo.getMnum() %>>
						<input type="hidden" name="mid" id="mid" value=<%= _kcvo.getMid() %>>
						</td>
						<td class="tt">
							<img src="/kosSpring/fileupload/product/<%= _kcvo.getKpfile() %>" alt="img" width="50" height="50">
							<%= _kcvo.getKpid() %>
						</td>
						<td class="tt"><%= kpprice %></td> 
						<td class="tt"><%= _kcvo.getKpcnt() %></td> 
						<td class="tt"><%= kppricesum %></td> 
						<td class="tt">적립금</td> 
						<td class="tt">배송비</td> 
						<td class="tt" align="center">
							<input type="button" value="관심상품"><br>
							<button type="button" class="delBtn" name="delBtn" id="delBtn" value=<%= _kcvo.getKcnum() %>>삭제</button>
						</td>
					</tr><%
										}
						%>
					<tr>
						<td colspan="8" align='right'> 총 구매 금액 <%= NumUtill.comma(String.valueOf(sum)) %>
						</td>
						</tr>
						<tr>
						<td colspan="8" align="right"> 결제 예정금액 <font size="5" style="color:red;"> <%= NumUtill.comma(String.valueOf(sum)) %></font>원</td>
						</tr>
						<tr>
						<td colspan="8" align="left">
							<input type="button" value="선택 삭제" id="delsBtn">
							<input type="button" value="장바구니 비우기" id="delAllBtn">
							&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
							&nbsp; &nbsp; &nbsp;
							<input type="button" value="쇼핑하기" id="shopingBtn">
							<input type="button" value="주문하기" id="buyBtn">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</body>
</html>