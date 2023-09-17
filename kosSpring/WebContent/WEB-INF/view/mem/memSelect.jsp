<%@page import="org.apache.log4j.LogManager"%>
<%@page import="org.apache.log4j.Logger"%>
<%@page import="a.b.c.com.common.CodeUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="a.b.c.com.kos.mem.vo.KosMemberVO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script> 
		<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

		<%
		Logger log = LogManager.getLogger(this.getClass());

			Object obj = request.getAttribute("select");
			List<KosMemberVO> list = (List<KosMemberVO>)obj; 
			
			KosMemberVO kvo = list.get(0);
			
			String mhp = CodeUtil.hp(kvo.getMhp());
			
			String[] mhp_ = mhp.split("-");
			
			String mtel = CodeUtil.tel(kvo.getMtel());
			
			String[] mtel_ = mtel.split("-");
			
			String[] memail = kvo.getMemail().split("@");
			
			log.info(">>> : " + kvo.getMphoto());
			
		%>
		<script type="text/javascript">
			
			$(document).ready(function(){
				
				var gender = "<%=kvo.getMgender()%>";
				$(".mgender").each(function(){
					if($(this).val() == gender){
						$(this).prop("checked", true);
					}
				});
				
				var hobs = '<%=kvo.getMhobby()%>';
				var hob = hobs.split(',');
				
				for(var m = 0; m < hob.length; m++){
					var hobValue = hob[m];
					
					$(".mhobby").each(function(){
						if($(this).val() == hobValue){
							$(this).prop("checked", true);
						}
						
					});
				}
				
				var hp0 = "<%=mhp_[0]%>";
				
				$("#mhp").val(hp0).prop("selected",true);
				
				var tel0 = "<%=mtel_[0]%>";
				$("#mtel").val(tel0).prop("selected", true);
				
				$("#memail1").val("<%= memail[1]%>");
				
				
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
				
				$("#zonecode").click(function(){
				    new daum.Postcode({
				        oncomplete: function(data) {
					$("#mzonecode").val(data.zonecode);
					$("#mroadaddr").val(data.roadAddress);
					$("#mjibunaddr").val(data.jibunAddress);
				        }
				    }).open();
				
				});
				
				$("#updatebtn").click(function(){
					$("#memForm").attr({
						"action" : "kosMemberUpdate.ihv",
						"method" : "POST",
						"enctype" : "multipart/form-data"
					}).submit();
					
				});
				
				$("#back").click(function(){
					
					location.href = "kosMemberSelectAll.ihv"
				});
				
			});
		
		</script>
		<style type="text/css">
		
			div {		 
			margin: 0 auto; 		
			border:1px solid #6d82f3;
			display:table;
			}			
		
			td, th {
				 padding: 5px;
			}
		
			h3 {
				text-align: center;
			}	
			
			table, th, td {
		  		border: 1px solid black;  		
			}
	
			.photo {
			border:1px solid red;		
			width: 180px;
			height: 180px;		
			display: block;
				/*
					margin-reft: auto;
					margin-rigth; auto;
				*/		
				border-radius: 50%;
			}
		
		</style>
	</head>
	<body>
		<h3>SPRING MYBATIS 회원정보수정</h3>
		<hr>
		<div>
			<form name = "memForm" id="memForm">
				<table border="1">
					<tr>
						<td colspan="3" align="center">KOSMO 129기</td>
					</tr>
					<tr>
						<td>회원번호</td>
						<td><input type="text" name="mnum" id="mnum" value="<%=kvo.getMnum() %>" readonly></td>
						<td rowspan="3"><img class = "photo" src="/kosSpring/fileupload/mem/<%= kvo.getMphoto()%>" border="1" width="50" height="50" alt="image"></td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input type="text" name="mname" value="<%= kvo.getMname() %>" id="mname" ></td>
					</tr>
					<tr>
						<td>아이디</td>
						<td><input type="text" name="mid" id="mid" value="<%= kvo.getMid() %>" placeholder="아이디체크" style="width:100px" readonly>
						</td>
					</tr>
					<tr>
						<td>패스워드</td>
						<td colspan="2">
							<input  type="text" name="mpw" id="mpw" value="<%=kvo.getMpw() %>" style="width:100px" readonly><br>
							<div id ="pwtxt" style="font-size:10px; color:red; visibility: hidden;">비밀번호는 영어대소문자, 특수문자(!"#$%&), 숫자가 포함된 8~12자리 입니다.</div>
							<input type="text" name="mpw_r" id="mpw_r" placeholder="비밀번호확인" style="width:100px">
							<input type="button" name="mpwbtn" id="mpwbtn" value="비밀번호확인">
						</td>
					</tr>
					<tr>
						<td>성별</td>
						<td colspan="2">
							<input type="radio" class="mgender" name="mgender" id="mgender_f" value="F" checked> 여자
							<input type="radio" class="mgender" name="mgender" id="mgender_m" value="M" > 남자
						</td>
					</tr>
					<tr>
						<td>생년월일</td>
						<td colspan="2">
							<input type="date" name="mbirth" id="mbirth" value="<%= kvo.getMbirth()%>">
						</td>
					</tr>
					<tr>
						<td>핸드폰</td>
						<td colspan="2"><select name="mhp" id="mhp">
							<option value="010">010</option>
							<option value="011">011</option>
							<option value="016">016</option>
							<option value="017">017</option>
							<option value="019">019</option>
						</select>
						- <input type="text" name="mhp1" id="mhp1" size="2" maxlength="4" value="<%= mhp_[1]%>">
						- <input type="text" name="mhp2" id="mhp2" size="2" maxlength="4" value="<%= mhp_[2]%>">
						</td>
					</tr>
					<tr>
						<td>전화번호</td>
						<td colspan="2"><select name="mtel" id="mtel">
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
						- <input type="text" name="mtel1" id="mtel1" size="2" maxlength="3" value="<%= mtel_[1]%>" >
						- <input type="text" name="mtel2" id="mtel2" size="2" maxlength="4" value="<%= mtel_[2]%>">
						</td>
					</tr>
					<tr>
						<td>이메일</td>
						<td colspan="2">
						<input type="text" name="memail" id="memail" style="width:100px" value="<%= memail[0]%>">
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
						<td colspan="2">
							<input type="text" name="mzonecode" id="mzonecode" placeholder="우편번호" style="width:50px" value="<%= kvo.getMzonecode()%>">
							<input type="button" name="zonecode" id="zonecode" value="우편번호 찾기"><br>
							<input type="text" name="mroadaddr" id="mroadaddr" placeholder="도로명주소" style="width:250px" value="<%= kvo.getMroadaddr()%>"><br>
							<input type="text" name="mroaddetail" id="mroaddetail" placeholder="도로명주소 상세주소" style="width:250px" value="<%= kvo.getMroaddetail()%>"><br>
							<input type="text" name="mjibunaddr" id="mjibunaddr" placeholder="지번주소" style="width:250px" value="<%= kvo.getMjibunaddr()%>">
						</td>	
					</tr>
					<tr>
						<td>취미</td>
						<td colspan="2">
							<input type="checkbox" class="mhobby" name="mhobby" value="01">운동
							<input type="checkbox" class="mhobby" name="mhobby" value="02">여행
							<input type="checkbox" class="mhobby" name="mhobby" value="03">독서
							<input type="checkbox" class="mhobby" name="mhobby" value="04">음악감상
						</td>
					</tr>
					<tr>
						<td>소개글</td>
						<td colspan="2">
							<textarea name="minfo" id="minfo" rows="5" cols="50"><%=kvo.getMinfo() %></textarea>
						</td>
					</tr>
					<tr>
						<td>사진</td>
						<td colspan="2">
							<input type="file" name="mphoto1" id="mphoto1" > 
							<input type="hidden" name="mphoto" id="mphoto" value="<%= kvo.getMphoto()%>"> 
						</td>
					</tr>
					<tr>
						<td colspan="3">
							<button type="button" id="updatebtn"> 수정</button>
							<button type="button" id="back"> 이전</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>