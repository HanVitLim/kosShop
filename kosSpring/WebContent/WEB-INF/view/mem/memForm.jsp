<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0
     				maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
 		<script  src="http://code.jquery.com/jquery-latest.min.js"></script> 

		<script type="text/javascript">
			alert("자바스크립트 블럭 시작 >>> : ");
		
			$(document).ready(function(){
				
				$("#btn").click(function(){
					$("#memForm").attr({
						"action" : "memInsert.ihv",
						"method" : "POST",
						"enctype" : "multipart/form-data"
						
					}).submit();
				});
				
				$("#mpw").keyup(function(){
					
					let pwurl = "pwCheck.ihv";
					let pwtype = "GET";
					let pwdataParam = { mpw : $("#mpw").val(),};
					
					$.ajax({
						url : pwurl,
						type : pwtype,
						data : pwdataParam,
						success : whenSuccessPw,
						error : whenErrorPw,
					})
					
					
					function whenSuccessPw(resData){
						if("PW_YES" == resData){
							$("#pwtxt").css("visibility", "hidden");
						}else{
							$("#pwtxt").css("visibility", "visible");
						}
					}
					
					function whenErrorPw(e){
						alert("e >>> : " + e.responseText)
					}
					
				});
				
				$("#midbtn").click(function(){
					let idurl = "Idcheck.ihv";
					let idtype = "GET";
					let iddataParam = { mid: $("#mid").val(),};
					
					$.ajax({
						url : idurl,
						type : idtype,
						data: iddataParam,
						success: whenSuccess,
						error: whenError
						
					});
					
					function whenSuccess(resData){
						alert(resData);
						if("ID_YES" == resData){
							alert("아이디 사용 가능 : ID_YES.");
							
							$("#mid").attr("readonly", true);
							$("#mpw").focus();
							
						}else{
							alert("이미 아이디 사용중 : ID_NO");
							$("#mid").val('');
							$("#mid").focus();
						}
						
					}
					
					function whenError(e){
						alert("e >>> : " + e.responseText)
					}
					
					
				});
				
				$('#memail2').change(function(){
					$('#memail2 option:selected').each(function(){
						if($(this).val() == '1'){
							var aa = $("#memail1").val();
							$("#memail1").val('');
							$("#memail1").attr("readonly", false);
						}else{
							$("#memail1").val($(this).text());
							$("#memail1").attr("readonly", true);
						}
					});	
				});
				
				$("#mpwbtn").click(function(){

					if($("#mpw").val() != "" && $("#mpw_r").val() != ""){
					if($("#mpw").val() == $("#mpw_r").val()){
						alert("비밀번호가 같습니다.");
						$("#mpw_r").val("");
					}else{
						alert("비밀번호가 틀립니다.");
						$("#mpw_r").val("");
						$("#mpw").val("");
						$("#mpw").focus();
					}
					}else{
						alert("비밀번호를 입력해주세요");
					}
				});
				
				$("#zonecode").click(function(){
				    new daum.Postcode({
				        oncomplete: function(data) {
					$("#mzonecode").val(data.zonecode);
					$("#mroadaddr").val(data.roadAddress);
					$("#mjibunaddr").val(data.jibunAddress);
				        }
				    }).open();
				
				});
			});
		</script>
	</head>
	<body>
		<h3>SPRING MYBATIS 회원가입</h3>
		<hr>
		<div>
			<form name = "memForm" id="memForm">
				<table border="1">
					<tr>
						<td colspan="2" align="center">KOSMO 129기</td>
					</tr>
					<tr>
						<td>회원번호</td>
						<td><input type="text" name="mnum" id="mnum" readonly></td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input type="text" name="mname" id="mname"></td>
					</tr>
					<tr>
						<td>아이디</td>
						<td><input type="text" name="mid" id="mid" placeholder="아이디체크" style="width:100px">
							<input type="button" name="midbtn" id="midbtn" value="아이디중복확인">
						</td>
					</tr>
					<tr>
						<td>패스워드</td>
						<td>
							<input type="text" name="mpw" id="mpw"  style="width:100px"><br>
							<div id ="pwtxt" style="font-size:10px; color:red; visibility: hidden;">비밀번호는 영어대소문자, 특수문자(!"#$%&), 숫자가 포함된 8~12자리 입니다.</div>
							<input type="text" name="mpw_r" id="mpw_r" placeholder="비밀번호확인" style="width:100px">
							<input type="button" name="mpwbtn" id="mpwbtn" value="비밀번호확인">
						</td>
					</tr>
					<tr>
						<td>성별</td>
						<td>
							<input type="radio" name="mgender" id="mgender_f" value="F" checked> 여자
							<input type="radio" name="mgender" id="mgender_m" value="M" > 남자
						</td>
					</tr>
					<tr>
						<td>생년월일</td>
						<td>
							<input type="date" name="mbirth" id="mbirth">
						</td>
					</tr>
					<tr>
						<td>핸드폰</td>
						<td><select name="mhp" id="mhp">
							<option value="010">010</option>
							<option value="011">011</option>
							<option value="016">016</option>
							<option value="017">017</option>
							<option value="019">019</option>
						</select>
						- <input type="text" name="mhp1" id="mhp1" size="2" maxlength="4">
						- <input type="text" name="mhp2" id="mhp2" size="2" maxlength="4">
						</td>
					</tr>
					<tr>
						<td>전화번호</td>
						<td><select name="mtel" id="mtel">
							<option value="02">02</option>
							<option value="031">031</option>
							<option value="032">032</option>
							<option value="033">033</option>
							<option value="041">041</option>
							<option value="042">042</option>
							<option value="043">043</option>
							<option value="044">044</option>
							<option value="051">051</option>
							<option value="052">052</option>
							<option value="053">053</option>
							<option value="054">054</option>
							<option value="055">055</option>
							<option value="061">061</option>
							<option value="062">062</option>
							<option value="063">063</option>
							<option value="064">064</option>
						</select>
						- <input type="text" name="mtel1" id="mtel1" size="2" maxlength="3">
						- <input type="text" name="mtel2" id="mtel2" size="2" maxlength="4">
						</td>
					</tr>
					<tr>
						<td>이메일</td>
						<td>
						<input type="text" name="memail" id="memail" style="width:100px">
						@<input type="text" name="memail1" id="memail1" style="width:100px" placeholder="직접입력">
						<select name="memail2" id="memail2" style="width:100px; mmargin-right:10px">
							<option value= "1" selected>직접입력</option>
							<option value="naver.com">naver.com</option>
							<option value="gmail.com">gmail.com</option>
							<option value="daum.net">daum.net</option>
						</select>
						</td>
					</tr>
					<tr>
						<td>주소</td>
						<td>
							<input type="text" name="mzonecode" id="mzonecode" placeholder="우편번호" style="width:50px">
							<input type="button" name="zonecode" id="zonecode" value="우편번호 찾기"><br>
							<input type="text" name="mroadaddr" id="mroadaddr" placeholder="도로명주소" style="width:250px"><br>
							<input type="text" name="mroaddetail" id="mroaddetail" placeholder="도로명주소 상세주소" style="width:250px"><br>
							<input type="text" name="mjibunaddr" id="mjibunaddr" placeholder="지번주소" style="width:250px">
						</td>	
					</tr>
					<tr>
						<td>취미</td>
						<td>
							<input type="checkbox" name="mhobby" value="01">운동
							<input type="checkbox" name="mhobby" value="02">여행
							<input type="checkbox" name="mhobby" value="03">독서
							<input type="checkbox" name="mhobby" value="04">음악감상
						</td>
					</tr>
					<tr>
						<td>소개글</td>
						<td>
							<textarea name="minfo" id="minfo" rows="5" cols="50">내 소개글</textarea>
						</td>
					</tr>
					<tr>
						<td>사진</td>
						<td>
							<input type="file" name="mphoto" id="mphoto"> 
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<button type="button" id="btn"> 보내기</button>
							<button type="reset"> 다시</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>