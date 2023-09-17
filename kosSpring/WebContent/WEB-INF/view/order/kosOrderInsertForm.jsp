<%@page import="a.b.c.com.common.NumUtill"%>
<%@page import="org.apache.log4j.LogManager"%>
<%@page import="org.apache.log4j.Logger"%>
<%@page import="a.b.c.com.kos.cart.vo.KoscartVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	Logger log = LogManager.getLogger(this.getClass());

	Object obj = request.getAttribute("list");
	log.info(" >>> : " + obj);
	List<KoscartVO> aList = (List<KoscartVO>)obj;

	String kpname = aList.get(0).getKpname() + " 외 " + String.valueOf(aList.size() - 1) + "개";
	int kppricesum = 0;
	int kpcnt = 0;
	for (int ii = 0; ii < aList.size(); ii++ ){
		
		kppricesum += Integer.parseInt(aList.get(ii).getKppricesum());
		kpcnt += Integer.parseInt(aList.get(ii).getKpcnt()); 
	}
	
	String kppricesum_1 = NumUtill.comma(String.valueOf(kppricesum));
	log.info(" >>>> : " + kppricesum_1);
	log.info(" >>>> : " + kpname);
	log.info(" >>> : " + kpcnt);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Iamport 결제 api   -->
<script src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<!-- 다음 우편번호 주소 -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="/kosmoSprng/js/common.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	var kpname = '<%= kpname %>';
	var kppricesum = '<%= kppricesum%>';		
	alert(kpname + " : " + kppricesum);
	alert(typeof(parseInt(kppricesum)))
	alert(parseInt(kppricesum))
	
	// 이메일 
	$('#koemail2').change(function(){	
		$("#koemail2 option:selected").each(function () {
			if($(this).val()== '1'){ //직접입력일 경우 
					var aa = $("#koemail1").val();						
					$("#koemail1").val(''); //값 초기화 
					$("#koemail1").attr("readonly",false); //활성화 				
			}else{ //직접입력이 아닐경우 
					$("#koemail1").val($(this).text()); //선택값 입력 
					$("#koemail1").attr("readonly",true); //비활성화 
			}
		}); 
	}); 	
	
	// 우편번호	
	$("#zoneBtn").click(function(){
		console.log("zonecode >>> : ");
		new daum.Postcode({
			oncomplete: function(data) {
			    $("#kozone").val(data.zonecode); //5자리 새우편번호 사용
			    $("#koroad").val(data.roadAddress); //도로명 주소
			    $("#kojibun").val(data.jibunAddress); //지번주소			
			}
		}).open();
	});
	

	$(document).on('click', '#orderBtn', function(){	
		
		var kohp0 = $("#kohp").val();
		var kohp1 = $("#kohp1").val();
		var kohp2 = $("#kohp2").val();
		var khp = kohp0 + "-" + kohp1 + "-" + kohp2
		
		console.log(khp)

		var koemail = $("#koemail").val();
		var koemail1 = $("#koemail1").val();
		kmemail = koemail + "@" + koemail1
		console.log(kmemail)
		
		$("#kmhp").val(khp);
		$("#kmemail").val(kmemail);
		
		alert(">>> : " + typeof($("#kmhp").val()));
		alert(">>> : " + typeof($("#kmemail").val()));
		alert(">>> : " + $("#kmemail").val());
		
		$("#orderForm").attr({"action":"kosOrderInsert.ihv","method":"GET"}).submit();	
	});
	
	$(document).on('click', '#cardBtn', function(){			
		
		//가맹점 식별코드
		IMP.init('imp23814146');
		IMP.request_pay({
		    pg : 'TC0ONETIME',
		    pay_method : 'card',
		    merchant_uid : 'merchant_' + new Date().getTime(),
		    name : kpname , //결제창에서 보여질 이름
		    amount : parseInt(kppricesum) , //실제 결제되는 가격
		    buyer_email : 'dkdje@naver.com',
		    buyer_name : '홍길동',
		    buyer_tel : '010-1234-5678',
		    buyer_addr : '서울 양찬구 목동',
		    buyer_postcode : '123-456'
		}, function(rsp) {
			console.log(rsp);
		    if ( rsp.success ) {
		    	var msg = '결제가 완료되었습니다.';
		        msg += '고유ID : ' + rsp.imp_uid;
		        msg += '상점 거래ID : ' + rsp.merchant_uid;
		        msg += '결제 금액 : ' + rsp.paid_amount;
		        msg += '카드 승인번호 : ' + rsp.apply_num;
		    } else {
		    	 var msg = '결제에 실패하였습니다.';
		         msg += '에러내용 : ' + rsp.error_msg;
		    }
		    alert(msg);
		});
	});
});



</script>

</head>
<style type="text/css">

	.mem {
		text-align: center;
	}
	
	h3 {
		text-align: center;
	}

</style>
</head>
<body>
<h3>주문하기</h3>
<hr>

<form name="orderForm" id="orderForm">
<table border="1" align="center">
<tr>
<td colspan="6" align="center">					
	<font size="4" style="color:blue;">상품 주문하기</font> 
	<img src="/kosSpring/img/img_mandu/ase.gif" width="25" height="25" alt="image">
</td>
</tr>
<tr>
<td colspan="6" align="left"><font size="3" style="color:blue;">1. 주문확인</font></td>
</tr>
<tr>
<td class="mem">주문 상품명</td>
<td class="mem">수량</td>
<td class="mem">주문금액</td>
<td class="mem">배송비</td>
<td class="mem">적립금</td>
<td class="mem">주문금액합계</td>
</tr>
<% 	for (int i = 0; i < aList.size(); i++){ %>
<tr>
<td class="mem">
<img src="/kosSpring/fileupload/product/<%= aList.get(i).getKpfile() %>" width="50" height="50" alt="img">
</td>
<td class="mem"><%= aList.get(i).getKpcnt() %>개</td>
<td class="mem"><input type="hidden" name="kpprice" id="kpprice"value="<%= aList.get(i).getKpprice() %>"><%= NumUtill.comma(aList.get(i).getKpprice()) %>원</td>
<td class="mem">0원</td>
<td class="mem">1000원
<input type="hidden" name="kpnum" id="kpnum"value="<%= aList.get(i).getKpnum() %>">
<input type="hidden" name="kpname" id="kpname"value="<%= aList.get(i).getKpname() %>">
<input type="hidden" name="kpid" id="kpid"value="<%= aList.get(i).getKpid() %>">
</td>
<td class="mem"><%= NumUtill.comma(aList.get(i).getKppricesum()) %>원</td>
<% } %>
</tr>
<tr>
	<td colspan='2' class='mem'>수량 합계</td>
	<td class='mem'><%= NumUtill.comma(String.valueOf(kpcnt)) %> 개</td>
	<td colspan='2' class="mem">최종 금액
		<input type="hidden" name="kpcnt" id="kpcnt" value="<%= kpcnt %>">
		<input type="hidden" name="kppricesum" id="kppricesum" value="<%= kppricesum %>">
	</td>
	<td class="mem"><%= kppricesum_1 %> 원</td>
</tr>
<tr>
<td colspan="6" align="left"><font size="3" style="color:blue;">2. 배송지 정보</font></td>
</tr>
<tr>
	<td>배송방법</td>
	<td colspan="5">
		<input type="radio" name="kodelivery" id="kodelivery_01" value="01" checked/>일반택배
		<input type="radio" name="kodelivery" id="kodelivery_02" value="02"/>편의점택배
		<input type="radio" name="kodelivery" id="kodelivery_03" value="03"/>해외배송
	</td>
</tr>
<tr>
	<td>받은실 분</td>
	<td colspan="5"><input type="text" name="kmname" id="kmname"/></td>
</tr>
<tr>
	<td>핸드폰</td>
	<td colspan="5">
		<select name="kohp" id="kohp">
        	<option value="010">010</option>
        	<option value="011">011</option>
        	<option value="016">016</option>
        	<option value="017">017</option>		        	
         </select>
         - <input type="text" name="kohp1" id="kohp1" size="2" maxlength="4" />
         - <input type="text" name="kohp2" id="kohp2" size="2" maxlength="4" />
           <input type="hidden" name="kmhp" id="kmhp" value="">
         
	</td>
</tr>
<tr>
	<td>이메일</td>
	<td  colspan="5">		
		 <input type="hidden" name="kmemail" id="kmemail" value="">
		<input type="text" name="koemail"  id="koemail" style="width:100px"/>
		@ <input type="text" name="koemail1" id="koemail1" style="width:100px" placeholder="직접입력" />
		<select name="koemail2" id="koemail2">
        	 <option value="1" selected>직접입력</option>
       		 <option value="naver.com">naver.com</option>	       	   
      		 <option value="gmail.com">gmail.com</option>
      		 <option value="daum.net">daum.net</option>	       	   
         </select>
	</td>
</tr>
<tr>
 	<td>주소</td>
 	<td  colspan="5">
 		<input type="text" name="kozone" id="kozone" placeholder="우편번호" style="width:50px" maxlength="6" >
 		<input type="button" name="zoneBtn" id="zoneBtn" value="우편번호 찾기"><br>	 	
 		<input type="text" name="koroad" id="koroad" placeholder="도로명주소" style="width:250px"><br>	 	
 		<input type="text" name="koroad2" id="koroad2" placeholder="도로명주소 상세주소" style="width:250px"><br>	 	
 		<input type="text" name="kojibun" id="kojibun" placeholder="지번주소" style="width:250px">
 	</td>
</tr>	 
 <tr>
	<td  colspan="6" align="center"> 			
		<button type="button" id="orderBtn">주문</button>
		<button type="button" id="cardBtn">결제</button>
		<button type="reset">다시 </button>	
	</td>				
</tr>
</table>				 		        		     
</form>	

</body>
</html>